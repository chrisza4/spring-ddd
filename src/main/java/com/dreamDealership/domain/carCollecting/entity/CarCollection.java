package com.dreamDealership.domain.carCollecting.entity;

import java.util.Date;
import java.util.List;

import com.dreamDealership.domain.carCollecting.valueObject.CarColor;
import com.dreamDealership.domain.carCollecting.valueObject.Coordinate;
import com.dreamDealership.domain.carCollecting.valueObject.Status;
import com.dreamDealership.domain.carCollecting.valueObject.VehicleRegistrationId;
import com.dreamDealership.domain.validation.ValidationException;

import io.micrometer.common.util.StringUtils;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class CarCollection {
    // Reference, ScheduleTime, Owner, ContactName, ContactPhoneNumber, Address,
    // CarModel, Color, Status, CarRegistrationNumber

    public static CarCollection scheduled(String reference, Date scheduleTime, String contactName,
            String contactPhoneNumber,
            String address, String carModel, CarColor color, VehicleRegistrationId vehicleRegistrationId,
            Coordinate place)
            throws ValidationException {
        var result = new CarCollection();
        if (StringUtils.isBlank(reference)) {
            throw new ValidationException("Reference number is required");
        }
        if (StringUtils.isBlank(contactName)) {
            throw new ValidationException("Contact Name is required");
        }
        if (StringUtils.isBlank(contactPhoneNumber)) {
            throw new ValidationException("Contact Phone Number is required");
        }
        if (StringUtils.isBlank(address)) {
            throw new ValidationException("Address is required");
        }
        if (StringUtils.isBlank(carModel)) {
            throw new ValidationException("Car Model is required");
        }
        if (color == null) {
            throw new ValidationException("Color is required");
        }
        if (scheduleTime == null) {
            throw new ValidationException("Scheduled time is required");
        }
        if (scheduleTime.after(new Date())) {
            throw new ValidationException("Scheduled time must be after current time");
        }
        var vehicleRegistrationIdvalidationResult = vehicleRegistrationId.isValid();
        if (!vehicleRegistrationIdvalidationResult.getIsSuccess()) {
            throw new ValidationException(vehicleRegistrationIdvalidationResult.getErrorMessage());
        }
        var coordinateValidationReuslt = place.isValid();
        if (!coordinateValidationReuslt.getIsSuccess()) {
            throw new ValidationException(vehicleRegistrationIdvalidationResult.getErrorMessage());
        }

        result.reference = reference;
        result.scheduleTime = scheduleTime;
        result.contactName = contactName;
        result.contactPhoneNumber = contactPhoneNumber;
        result.address = address;
        result.carModel = carModel;
        result.color = color;
        result.vehicleRegistrationId = vehicleRegistrationId;
        result.status = Status.Scheduled;
        result.place = place;
        return result;
    }

    @Id
    @GeneratedValue
    private long id;

    private String reference;

    private Date scheduleTime;

    private String contactName;

    private String contactPhoneNumber;

    private String address;

    private String carModel;

    @Enumerated(EnumType.STRING)
    private CarColor color;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Embedded
    private VehicleRegistrationId vehicleRegistrationId;

    @Embedded
    private Coordinate place;

    @OneToMany
    private List<Pickup> pickups;

    // #region Getters-Setters

    public VehicleRegistrationId getVehicleRegistrationId() {
        return vehicleRegistrationId;
    }

    public void setVehicleRegistrationId(VehicleRegistrationId vehicleRegistrationId) {
        this.vehicleRegistrationId = vehicleRegistrationId;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public Coordinate getPlace() {
        return place;
    }

    public void setPlace(Coordinate place) {
        this.place = place;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Date getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(Date scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhoneNumber() {
        return contactPhoneNumber;
    }

    public void setContactPhoneNumber(String contactPhoneNumber) {
        this.contactPhoneNumber = contactPhoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public CarColor getColor() {
        return color;
    }

    public void setColor(CarColor color) {
        this.color = color;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    // #endregion

    public void carDroppedToWarehouse() throws ValidationException {
        if (this.status != Status.Scheduled) {
            throw new ValidationException("Car Collection already dropped");
        }
        this.status = Status.Dropped;
    }

    public void recordPickup(PickupResult result, String reason) throws ValidationException {
        var pickup = new Pickup(new Date(), result, reason);
        var pickupValidateResult = pickup.validate();
        if (!pickupValidateResult.getIsSuccess()) {
            throw new ValidationException(pickupValidateResult.getErrorMessage());
        }
        if (status != Status.Scheduled) {
            throw new ValidationException("Car Collection is not scheduled for picking up. Cannot record pickup");
        }

        pickups.add(pickup);
        if (pickup.getResult() == PickupResult.Success) {
            status = Status.PickedUp;
        }
    }

    public List<Pickup> listPickups() {
        throw new UnsupportedOperationException();
    }
}

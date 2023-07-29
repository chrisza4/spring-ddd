package com.dreamDealership.domain.carCollection.entity;

import java.util.Date;

import com.dreamDealership.domain.carCollection.valueObject.CarColor;
import com.dreamDealership.domain.carCollection.valueObject.Status;
import com.dreamDealership.domain.carCollection.valueObject.VehicleRegistrationId;
import com.dreamDealership.domain.validation.ValidationException;
import io.micrometer.common.util.StringUtils;

public class CarCollection {
    // Reference, ScheduleTime, Owner, ContactName, ContactPhoneNumber, Address,
    // CarModel, Color, Status, CarRegistrationNumber

    public long id;

    public static CarCollection scheduled(String reference, Date scheduleTime, String contactName,
            String contactPhoneNumber,
            String address, String carModel, CarColor color, VehicleRegistrationId vehicleRegistrationId)
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

        result.reference = reference;
        result.scheduleTime = scheduleTime;
        result.contactName = contactName;
        result.contactPhoneNumber = contactPhoneNumber;
        result.address = address;
        result.carModel = carModel;
        result.color = color;
        result.vehicleRegistrationId = vehicleRegistrationId;
        result.status = Status.Scheduled;
        return result;
    }

    private String reference;

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    private Date scheduleTime;

    public Date getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(Date scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    private String contactName;

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    private String contactPhoneNumber;

    public String getContactPhoneNumber() {
        return contactPhoneNumber;
    }

    public void setContactPhoneNumber(String contactPhoneNumber) {
        this.contactPhoneNumber = contactPhoneNumber;
    }

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private String carModel;

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    private CarColor color;

    public CarColor getColor() {
        return color;
    }

    public void setColor(CarColor color) {
        this.color = color;
    }

    private Status status;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    private VehicleRegistrationId vehicleRegistrationId;

    public VehicleRegistrationId getVehicleRegistrationId() {
        return vehicleRegistrationId;
    }

    public void setVehicleRegistrationId(VehicleRegistrationId vehicleRegistrationId) {
        this.vehicleRegistrationId = vehicleRegistrationId;
    }
}

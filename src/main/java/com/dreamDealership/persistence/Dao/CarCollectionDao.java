package com.dreamDealership.persistence.Dao;

import java.util.Date;

import com.dreamDealership.domain.carCollecting.entity.CarCollection;
import com.dreamDealership.domain.carCollecting.valueObject.CarColor;
import com.dreamDealership.domain.carCollecting.valueObject.Coordinate;
import com.dreamDealership.domain.carCollecting.valueObject.Status;
import com.dreamDealership.domain.carCollecting.valueObject.VehicleRegistrationId;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CarCollectionDao {
    public static CarCollectionDao fromEntity(CarCollection entity) {
        var result = new CarCollectionDao();
        result.address = entity.getAddress();
        result.carModel = entity.getCarModel();
        result.color = entity.getColor().toString();
        result.contactName = entity.getContactName();
        result.contactPhoneNumber = entity.getContactPhoneNumber();
        result.id = entity.getId();
        result.latitude = entity.getPlace().getLatitude();
        result.longitude = entity.getPlace().getLongitude();
        result.scheduleTime = entity.getScheduleTime();
        result.status = entity.getStatus().toString();
        result.vehicleRegistrationId = entity.getVehicleRegistrationId().getId();

        return result;
    }

    public CarCollection toEntity() {
        var result = new CarCollection();
        result.setAddress(getAddress());
        result.setCarModel(getCarModel());
        result.setColor(CarColor.valueOf(getColor()));
        result.setContactName(getContactName());
        result.setContactPhoneNumber(getContactPhoneNumber());
        result.setId(id);
        result.setPlace(new Coordinate(latitude, longitude));
        result.setScheduleTime(getScheduleTime());
        result.setStatus(Status.valueOf(status));
        result.setVehicleRegistrationId(new VehicleRegistrationId(vehicleRegistrationId));

        return result;
    }

    @Id
    public long id;

    private String reference;

    private Date scheduleTime;

    private String contactName;

    private String contactPhoneNumber;

    private String address;

    private String carModel;

    // Notice how color and status become string
    private String color;

    private String status;

    private String vehicleRegistrationId;

    private Double latitude;
    private Double longitude;

    public String getVehicleRegistrationId() {
        return vehicleRegistrationId;
    }

    public void setVehicleRegistrationId(String vehicleRegistrationId) {
        this.vehicleRegistrationId = vehicleRegistrationId;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

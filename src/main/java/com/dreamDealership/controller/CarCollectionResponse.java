package com.dreamDealership.controller;

import java.util.Date;
import java.util.List;

import com.dreamDealership.domain.carCollecting.entity.CarCollection;
import com.dreamDealership.domain.carCollecting.entity.Pickup;
import com.dreamDealership.domain.carCollecting.valueObject.CarColor;
import com.dreamDealership.domain.carCollecting.valueObject.Coordinate;
import com.dreamDealership.domain.carCollecting.valueObject.Status;

public class CarCollectionResponse {
    private long id;

    private String reference;

    private Date scheduleTime;

    private String contactName;

    private String contactPhoneNumber;

    private String address;

    private String carModel;

    private CarColor color;

    private Status status;

    private String vehicleRegistrationId;

    private Coordinate place;

    private List<Pickup> pickups;

    public static CarCollectionResponse fromEntity(CarCollection entity) {
        var result = new CarCollectionResponse();
        result.id = entity.getId();
        result.reference = entity.getReference();
        result.scheduleTime = entity.getScheduleTime();
        result.contactName = entity.getContactName();
        result.contactPhoneNumber = entity.getContactPhoneNumber();
        result.address = entity.getAddress();
        result.carModel = entity.getCarModel();
        result.color = entity.getColor();
        result.status = entity.getStatus();
        result.vehicleRegistrationId = entity.getVehicleRegistrationId().getId();
        result.place = entity.getPlace();

        return result;
    }

    public long getId() {
        return id;
    }

    public String getReference() {
        return reference;
    }

    public Date getScheduleTime() {
        return scheduleTime;
    }

    public String getContactName() {
        return contactName;
    }

    public String getContactPhoneNumber() {
        return contactPhoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getCarModel() {
        return carModel;
    }

    public CarColor getColor() {
        return color;
    }

    public Status getStatus() {
        return status;
    }

    public String getVehicleRegistrationId() {
        return vehicleRegistrationId;
    }

    public Coordinate getPlace() {
        return place;
    }

    public List<Pickup> getPickups() {
        return pickups;
    }

}

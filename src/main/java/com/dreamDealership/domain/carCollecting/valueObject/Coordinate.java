package com.dreamDealership.domain.carCollecting.valueObject;

import com.dreamDealership.domain.validation.ValidationResult;

import jakarta.persistence.Embeddable;

@Embeddable
public class Coordinate {
    private double latitude;
    private double longitude;

    public Coordinate() {

    }

    public Coordinate(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public ValidationResult isValid() {
        if (this.latitude <= 90 && this.latitude >= -90 && this.longitude <= 180 && this.longitude >= -180) {
            return ValidationResult.success();
        }
        return ValidationResult
                .fail("Latitude must be in range of -90 and 90. Longitude must be in range of -180 and 180.");
    }
}

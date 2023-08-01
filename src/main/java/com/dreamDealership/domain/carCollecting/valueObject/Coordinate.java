package com.dreamDealership.domain.carCollecting.valueObject;

import com.dreamDealership.domain.validation.ValidationResult;

public class Coordinate {
    private final double latitude;
    private final double longitude;

    public Coordinate(double latitude, double longitude) {
        this.latitude = latitude;
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

package com.dreamDealership.domain.carCollecting.valueObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.dreamDealership.domain.validation.ValidationResult;

public class VehicleRegistrationId {

    private final String id;

    public String getId() {
        return id;
    }

    public VehicleRegistrationId(String id) {
        this.id = id;
    }

    public ValidationResult isValid() {
        String regexPattern = "[\\w\\s]*[-\\s]?[\\w\\s]*";
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(id);

        boolean isMatch = matcher.matches();
        if (!isMatch) {
            return ValidationResult.fail("Invalid Vehicle Registration Number");
        }
        return ValidationResult.success();
    }

}

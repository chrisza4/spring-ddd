package com.dreamDealership.domain.validation;

public class ValidationResult {
    private final Boolean isSuccess;
    private final String errorMessage;

    private ValidationResult(Boolean isSuccess, String errorMessage) {
        this.isSuccess = isSuccess;
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public Boolean getIsSuccess() {
        return isSuccess;
    }

    public static ValidationResult success() {
        return new ValidationResult(true, null);
    }

    public static ValidationResult fail(String errorMessage) {
        return new ValidationResult(false, errorMessage);
    }
}

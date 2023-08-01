package com.dreamDealership.domain.carCollecting.entity;

import java.util.Date;

import com.dreamDealership.domain.validation.ValidationResult;

import io.micrometer.common.util.StringUtils;

public class Pickup {
    private long id;

    private Date time;

    private PickupResult result;

    private String reason;

    protected Pickup(Date time, PickupResult result, String reason) {
        this.time = time;
        this.result = result;
        this.reason = reason;
    }

    protected Pickup() {

    }

    public Date getTime() {
        return time;
    }

    public PickupResult getResult() {
        return result;
    }

    public String getReason() {
        return reason;
    }

    protected long getId() {
        return id;
    }

    protected void setId(long id) {
        this.id = id;
    }

    protected void setTime(Date time) {
        this.time = time;
    }

    protected void setResult(PickupResult result) {
        this.result = result;
    }

    protected void setReason(String reason) {
        this.reason = reason;
    }

    protected ValidationResult validate() {
        if (result == PickupResult.Rescheduled && StringUtils.isBlank(reason)) {
            return ValidationResult.fail("Please provide reason for rescheduling");
        }
        return ValidationResult.success();
    }
}

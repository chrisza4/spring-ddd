package com.dreamDealership.domain.carCollecting.entity;

import java.util.Date;

import com.dreamDealership.domain.validation.ValidationException;
import com.dreamDealership.domain.warehouse.entity.Stock;

public class Loading {
    private CarCollection relatedCarCollection;
    private Stock relatedStock;

    private long id;
    private String receivedEmployeeId;
    private Date timestamp;
    private String comment;

    // And other related fields in the form
    public void droppedCarAtWarehouse() throws ValidationException {
        // Do something with its own entity
        // Such as validation, change things, etc.

        relatedCarCollection.carDroppedToWarehouse();
        relatedStock.incrementStockCountBy(1);
    }

    // #region Getters
    public long getId() {
        return id;
    }

    public CarCollection getRelatedCarCollection() {
        return relatedCarCollection;
    }

    public Stock getRelatedStock() {
        return relatedStock;
    }

    public String getReceivedEmployeeId() {
        return receivedEmployeeId;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getComment() {
        return comment;
    }
    // #endregion
}

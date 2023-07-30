package com.dreamDealership.domain.carCollection.entity;

public class Loading {
    private CarCollection relatedCarCollection;
    private Stock relatedStock;

    // And other related fields in the form
    public void DroppedCarAtWarehouse() {
        // Do something with its own entity
        // Such as validation, change things, etc.

        relatedCarCollection.carDroppedToWarehouse();
        relatedStock.incrementStockCountBy(1);
    }
}

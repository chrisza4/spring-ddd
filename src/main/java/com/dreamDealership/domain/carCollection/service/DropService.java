package com.dreamDealership.domain.carCollection.service;

import com.dreamDealership.repository.DatabaseAccessor;

public class DropService {
    // For now
    private DatabaseAccessor db;

    public void dropCarAtWarehouse(int carCollectionId) {
        var carCollection = db.getCarCollectionById(carCollectionId);
        var stock = db.getStockByModel(carCollection.getCarModel());

        carCollection.carDroppedToWarehouse();
        stock.incrementStockCountBy(1);
    }
}

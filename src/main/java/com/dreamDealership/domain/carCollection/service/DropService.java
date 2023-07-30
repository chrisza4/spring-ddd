package com.dreamDealership.domain.carCollection.service;

import com.dreamDealership.domain.carCollection.entity.*;

public class DropService {
    public void dropCarAtWarehouse(CarCollection collection, Stock stock) {
        collection.carDroppedToWarehouse();
        stock.incrementStockCountBy(1);
    }
}

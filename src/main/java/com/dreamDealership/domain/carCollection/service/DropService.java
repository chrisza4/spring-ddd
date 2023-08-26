package com.dreamDealership.domain.carCollection.service;

import com.dreamDealership.domain.carCollection.entity.CarCollection;
import com.dreamDealership.domain.carCollection.entity.Stock;

public class DropService {

    public void dropCarAtWarehouse(CarCollection carCollection, Stock stock) {
        carCollection.carDroppedToWarehouse();
        stock.incrementStockCountBy(1);
    }
}

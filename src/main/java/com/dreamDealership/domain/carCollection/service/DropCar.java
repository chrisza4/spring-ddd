package com.dreamDealership.domain.carCollection.service;

import com.dreamDealership.domain.carCollection.entity.CarCollection;
import com.dreamDealership.domain.carCollection.entity.Stock;

public class DropCar {
    public void operate(CarCollection carCollection, Stock stock) {
        carCollection.carDroppedToWarehouse();
        stock.incrementStockCountBy(1);
    }
}

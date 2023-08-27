package com.dreamDealership.domain.carCollecting.service;

import com.dreamDealership.domain.carCollecting.entity.CarCollection;
import com.dreamDealership.domain.carCollecting.entity.Stock;
import com.dreamDealership.domain.validation.ValidationException;

public class DropCar {
    public void operate(CarCollection carCollection, Stock stock) throws ValidationException {
        carCollection.carDroppedToWarehouse();
        stock.incrementStockCountBy(1);
    }
}

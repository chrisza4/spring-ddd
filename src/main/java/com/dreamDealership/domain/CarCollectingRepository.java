package com.dreamDealership.domain;

import com.dreamDealership.domain.carCollecting.entity.CarCollection;
import com.dreamDealership.domain.warehouse.entity.Stock;

public interface CarCollectingRepository {

    CarCollection saveCarCollection(CarCollection entity);

    Stock saveStock(Stock entity);

    CarCollection getCarCollectionById(long id);

    Stock getStockByModel(String model);

}
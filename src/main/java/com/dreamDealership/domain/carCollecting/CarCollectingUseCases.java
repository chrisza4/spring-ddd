package com.dreamDealership.domain.carCollecting;

import org.springframework.stereotype.Component;

import com.dreamDealership.domain.CarCollectingRepository;
import com.dreamDealership.domain.carCollecting.entity.CarCollection;
import com.dreamDealership.domain.validation.ValidationException;

@Component
public class CarCollectingUseCases {

    private CarCollectingRepository carCollectingRepository;

    public CarCollectingUseCases(CarCollectingRepository carCollectionRepository) {
        this.carCollectingRepository = carCollectionRepository;
    }

    public CarCollection dropCarAtWarehouse(long carCollectionId) throws ValidationException {
        var carCollection = carCollectingRepository.getCarCollectionById(carCollectionId);
        var stock = carCollectingRepository.getStockByModel(carCollection.getCarModel());

        carCollection.carDroppedToWarehouse();
        stock.incrementStockCountBy(1);

        carCollectingRepository.saveStock(stock);
        carCollection = carCollectingRepository.saveCarCollection(carCollection);
        return carCollection;
    }
}

package com.dreamDealership.domain.carCollecting;

import org.springframework.stereotype.Component;

import com.dreamDealership.domain.carCollecting.entity.CarCollection;
import com.dreamDealership.domain.validation.ValidationException;
import com.dreamDealership.persistence.CarCollectingRepositoryJpa;

@Component
public class CarCollectingUseCases {
    // For now
    private CarCollectingRepositoryJpa carCollectingRepository;

    public CarCollectingUseCases(CarCollectingRepositoryJpa carCollectionRepository) {
        this.carCollectingRepository = carCollectionRepository;
    }

    public CarCollection dropCarAtWarehouse(int carCollectionId) throws ValidationException {
        var carCollection = carCollectingRepository.getCarCollectionById(carCollectionId);
        var stock = carCollectingRepository.getStockByModel(carCollection.getCarModel());

        carCollection.carDroppedToWarehouse();
        stock.incrementStockCountBy(1);

        carCollection = carCollectingRepository.saveCarCollection(carCollection);
        carCollectingRepository.saveStock(stock);

        return carCollection;
    }
}

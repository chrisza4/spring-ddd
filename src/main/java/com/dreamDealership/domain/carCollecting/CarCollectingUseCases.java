package com.dreamDealership.domain.carCollecting;

import org.springframework.stereotype.Component;

import com.dreamDealership.domain.carCollecting.entity.CarCollection;
import com.dreamDealership.domain.validation.ValidationException;
import com.dreamDealership.persistence.CarCollectionRepository;
import com.dreamDealership.persistence.StockRepository;

@Component
public class CarCollectingUseCases {

    private CarCollectionRepository carCollectionRepository;
    private StockRepository stockRepository;

    public CarCollectingUseCases(CarCollectionRepository carCollectionRepository, StockRepository stockRepository) {
        this.carCollectionRepository = carCollectionRepository;
        this.stockRepository = stockRepository;
    }

    public CarCollection dropCarAtWarehouse(long carCollectionId) throws ValidationException {
        var carCollection = carCollectionRepository.findById(carCollectionId).get();
        var stock = stockRepository.findByModel(carCollection.getCarModel()).get(0);

        carCollection.carDroppedToWarehouse();
        stock.incrementStockCountBy(1);

        stockRepository.save(stock);
        carCollection = carCollectionRepository.save(carCollection);
        return carCollection;
    }
}

package com.dreamDealership.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dreamDealership.domain.carCollecting.entity.CarCollection;
import com.dreamDealership.domain.carCollecting.entity.Stock;

@Component
public class CarCollectingRepositoryImpl implements com.dreamDealership.domain.CarCollectingRepository {

    @Autowired
    private CarCollectionRepository carCollectionRepository;
    @Autowired
    private StockRepository stockRepository;

    @Override
    public CarCollection saveCarCollection(CarCollection entity) {
        return carCollectionRepository.save(entity);
    }

    @Override
    public Stock saveStock(Stock entity) {
        return stockRepository.save(entity);
    }

    @Override
    public CarCollection getCarCollectionById(long id) {
        return carCollectionRepository.findById(id).orElse(null);
    }

    @Override
    public Stock getStockByModel(String model) {
        var stocks = stockRepository.findByModel(model);
        return stocks.size() == 0 ? null : stocks.get(0);
    }

}

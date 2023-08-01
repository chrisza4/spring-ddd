package com.dreamDealership.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dreamDealership.domain.CarCollectingRepository;
import com.dreamDealership.domain.carCollecting.entity.*;
import com.dreamDealership.persistence.Dao.CarCollectionDao;
import com.dreamDealership.persistence.Dao.CarCollectionRepository;
import com.dreamDealership.persistence.Dao.StockDao;
import com.dreamDealership.persistence.Dao.StockRepository;

@Service
public class CarCollectingRepositoryJpa implements CarCollectingRepository {

    @Autowired
    private CarCollectionRepository carCollectionRepository;
    @Autowired
    private StockRepository stockRepository;

    @Override
    public CarCollection saveCarCollection(CarCollection entity) {
        // This can be good old SQL as well. such as

        // var statement = "UPDATE xxx SET yyy WHERE zzz";
        // db.executeSql(statement, params);

        // Implementation detail does not matter. Can implement anything that save
        // entity to database
        // So, I use JPA persistence because I can.
        // I will make some point later.
        var dao = CarCollectionDao.fromEntity(entity);
        return carCollectionRepository.save(dao).toEntity();
    }

    @Override
    public Stock saveStock(Stock entity) {
        // Same as above comment
        var dao = StockDao.fromEntity(entity);
        return stockRepository.save(dao).toEntity();
    }

    @Override
    public CarCollection getCarCollectionById(long id) {
        return carCollectionRepository.findById(id).get().toEntity();
    }

    @Override
    public Stock getStockByModel(String model) {
        return stockRepository.findByModel(model).stream().map(c -> c.toEntity()).findFirst().get();
    }
}

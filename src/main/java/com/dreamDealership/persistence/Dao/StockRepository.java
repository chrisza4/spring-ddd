package com.dreamDealership.persistence.Dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface StockRepository extends CrudRepository<StockDao, Long> {
    List<StockDao> findByModel(String model);
}

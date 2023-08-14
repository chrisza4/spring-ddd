package com.dreamDealership.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dreamDealership.domain.warehouse.entity.Stock;

public interface StockRepository extends CrudRepository<Stock, Long> {
    List<Stock> findByModel(String model);
}

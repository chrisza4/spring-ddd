package com.dreamDealership.repository;

import org.springframework.data.repository.CrudRepository;

import com.dreamDealership.model.Car;

public interface CarRepository extends CrudRepository<Car, Long> {

}

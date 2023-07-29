package com.dreamDealership.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dreamDealership.model.Car;
import com.dreamDealership.repository.CarRepository;

@Service
public class CarService {

    @Autowired
    CarRepository carRepository;

    public Car create(Car newCar) {
        return carRepository.save(newCar);
    }

    public Iterable<Car> listCars() {
        return carRepository.findAll();
    }
}

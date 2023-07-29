package com.dreamDealership.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.dreamDealership.model.Car;
import com.dreamDealership.service.CarService;

@RestController
public class CarController {
    @Autowired
    CarService carService;

    @PostMapping("/cars")
    public Car CreateCar(@RequestBody Car newCar) {
        return carService.create(newCar);
    }
}

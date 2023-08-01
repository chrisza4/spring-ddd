package com.dreamDealership.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dreamDealership.domain.carCollecting.CarCollectingUseCases;
import com.dreamDealership.domain.validation.ValidationException;

@RestController
public class DropController {
    @Autowired
    CarCollectingUseCases carCollectingUseCases;

    @PostMapping("/car-collection/{id}/drop")
    public CarCollectionResponse dropCar(@PathVariable int id) throws ValidationException {
        return CarCollectionResponse.fromEntity(carCollectingUseCases.dropCarAtWarehouse(id));
    }
}

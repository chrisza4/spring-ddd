package com.dreamDealership.domain.carCollecting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dreamDealership.domain.DomainEvent;
import com.dreamDealership.domain.EventBus;
import com.dreamDealership.domain.carCollecting.entity.CarCollection;
import com.dreamDealership.domain.validation.ValidationException;
import com.dreamDealership.persistence.CarCollectionRepository;
import com.dreamDealership.persistence.StockRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class CarCollectingUseCases {

    private CarCollectionRepository carCollectionRepository;

    @Autowired
    private EventBus eventBus;

    public CarCollectingUseCases(CarCollectionRepository carCollectionRepository, StockRepository stockRepository) {
        this.carCollectionRepository = carCollectionRepository;
    }

    public CarCollection dropCarAtWarehouse(long carCollectionId) throws ValidationException {
        var carCollection = carCollectionRepository.findById(carCollectionId).get();

        carCollection.carDroppedToWarehouse();
        carCollection = carCollectionRepository.save(carCollection);

        // Publish event in JSON before return
        var objectMapper = new ObjectMapper();
        var carDroppedEventMetadata = new CarDroppedEvent();
        carDroppedEventMetadata.setModel(carCollection.getCarModel());
        try {
            eventBus.publish(DomainEvent.CarDropped, objectMapper.writeValueAsString(carDroppedEventMetadata));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return carCollection;
    }
}

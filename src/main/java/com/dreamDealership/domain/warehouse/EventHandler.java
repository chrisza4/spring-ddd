package com.dreamDealership.domain.warehouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.stereotype.Component;

import com.dreamDealership.domain.DomainEvent;
import com.dreamDealership.domain.EventBusSubscriber;
import com.dreamDealership.persistence.StockRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class EventHandler implements EventBusSubscriber {

    @Autowired
    private StockRepository stockRepository;

    @Override
    public void handleEvent(DomainEvent event, String metadata) {
        if (event == DomainEvent.CarDropped) {
            try {
                // Turns JSON into CarDroppedEvent
                var mapper = new ObjectMapper();
                var eventMetadata = mapper.readValue(metadata, CarDroppedEvent.class);

                // Execute domain logic
                var stock = stockRepository.findByModel(eventMetadata.getModel()).get(0);
                stock.incrementStockCountBy(1);
                stockRepository.save(stock);
            } catch (JsonMappingException e) {
                // Handle error
                e.printStackTrace();
            } catch (JsonProcessingException e) {
                // Handle error
                e.printStackTrace();
            }

        }
    }

}

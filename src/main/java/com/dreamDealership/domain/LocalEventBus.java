package com.dreamDealership.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

// Can be done via other technology as well
// For demonstration, we will do local
@Primary
@Component
public class LocalEventBus implements EventBus {

    public List<EventBusSubscriber> subscribers = new ArrayList<EventBusSubscriber>();

    @Override
    public void publish(DomainEvent event, String metadata) {
        for (var subscriber : subscribers) {
            subscriber.handleEvent(event, metadata);
        }
    }

    @Override
    public void subscribe(EventBusSubscriber subscriber) {
        subscribers.add(subscriber);
    }

}

package com.dreamDealership.domain;

public interface EventBus {
    public void publish(DomainEvent event, String metadata);

    public void subscribe(EventBusSubscriber subscriber);
}
package com.dreamDealership.domain;

public interface EventBusSubscriber {
    public void handleEvent(DomainEvent event, String metadata);
}

package com.dreamDealership.model;

import jakarta.persistence.*;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    public String serial;
    public String name;
    public String description;

    @Enumerated(EnumType.STRING)
    public CarStatus status = CarStatus.ScheduledForCollection;

    public Car() {

    }
}
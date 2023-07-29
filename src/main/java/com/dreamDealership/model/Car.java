package com.dreamDealership.model;

import jakarta.persistence.*;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public String serial;
    public String name;
    public String description;

    @Enumerated(EnumType.STRING)
    public CarStatus status;
}
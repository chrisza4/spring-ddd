package com.dreamDealership.domain.carCollecting.entity;

public class Stock {

    private long id;
    private long quantity;
    private String model;

    public void incrementStockCountBy(int count) {
        quantity += count;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}

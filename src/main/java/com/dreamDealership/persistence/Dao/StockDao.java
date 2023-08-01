package com.dreamDealership.persistence.Dao;

import com.dreamDealership.domain.carCollecting.entity.Stock;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class StockDao {
    @Id
    private long id;
    private String model;
    private long quantity;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public static StockDao fromEntity(Stock entity) {
        // All tedious mapping
        var result = new StockDao();
        result.setId(entity.getId());
        result.setModel(entity.getModel());
        result.setQuantity(entity.getQuantity());

        return result;

    }

    public Stock toEntity() {
        // Again.. all tedious mapping
        var result = new Stock();
        result.setId(this.getId());
        result.setModel(this.getModel());
        result.setQuantity(this.getQuantity());

        return result;
    }
}

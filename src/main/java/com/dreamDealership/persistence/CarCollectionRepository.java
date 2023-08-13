package com.dreamDealership.persistence;

import org.springframework.data.repository.CrudRepository;

import com.dreamDealership.domain.carCollecting.entity.CarCollection;

public interface CarCollectionRepository extends CrudRepository<CarCollection, Long> {

}

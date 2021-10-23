package com.amazetrip.api.dao;
import com.amazetrip.api.model.Trip;
import org.springframework.data.repository.CrudRepository;

public interface TripRepo extends CrudRepository<Trip, Integer> {
}

package com.amazetrip.api.dao;

import com.amazetrip.api.model.Place;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface PlaceRepo extends CrudRepository<Place, Integer> {
    Collection<Place> findPlacesByTrips_id(int id);
}

package com.amazetrip.app.dao;

import com.amazetrip.app.model.Place;
import org.springframework.data.repository.CrudRepository;

public interface PlaceRepo extends CrudRepository<Place, Integer> {

}
package com.amazetrip.app.dao;


import com.amazetrip.app.model.Trip;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TripRepository extends CrudRepository<Trip, Integer> {

}
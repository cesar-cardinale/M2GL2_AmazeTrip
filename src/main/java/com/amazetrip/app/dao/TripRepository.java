package com.amazetrip.app.dao;

import com.amazetrip.app.model.Trip;
import com.amazetrip.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface TripRepository extends JpaRepository<Trip, Integer> {

    List<Trip> findByUser(User user);
}
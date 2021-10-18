package com.amazetrip.app.controller;

import com.amazetrip.app.dao.TripRepository;
import com.amazetrip.app.model.Place;
import com.amazetrip.app.model.Trip;
import com.amazetrip.app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TripRestController {

    @Autowired
    TripRepository trips;

    @PostConstruct
    public void init(){
        var trip1 = new Trip();
        trip1.setCreationDate(new Date(2007, 1,1));
        var trip2 = new Trip();
        trip2.setCreationDate(new Date(2005, 2,2));
        var trip3 = new Trip();
        trip3.setCreationDate(new Date(2003, 3,3));

        trips.save(trip1);
        trips.save(trip2);
        trips.save(trip3);
    }

    @GetMapping("/trips")
    public List<Trip> getAllTrips(){
        return trips.findAll();
    }

    @GetMapping("/trips/{id}")
    public Trip getTripById(@PathVariable int id){
        if (trips.existsById(id))
            return null;
        return trips.findById(id).get();
    }

    @PostMapping("/trips")
    public Trip PostTripById(@RequestBody Trip t){
        if (trips.existsById(t.getId()))
            return null;
        trips.save(t);
        return t;
    }

    @PutMapping("/trips")
    public Trip PutTripById(@RequestBody Trip t){
        if (trips.existsById(t.getId())){
            trips.save(t);
            return t;
        }
        return null;
    }

    @GetMapping("/trips/user")
    public List<Trip> GetTripById(@RequestBody User t){
            return trips.findByUser(t);
    }
}

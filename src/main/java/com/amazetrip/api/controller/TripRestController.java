package com.amazetrip.api.controller;
import com.amazetrip.api.dao.PlaceRepo;
import com.amazetrip.api.dao.TripRepo;
import com.amazetrip.api.model.Place;
import com.amazetrip.api.model.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Set;

@RestController
@RequestMapping("/amazetrip/api")
public class TripRestController {
    @Autowired
    TripRepo tripRepo;
    @Autowired
    PlaceRepo placeRepo;

    @PostConstruct
    private void populateTripTable(){
        var placeM = new Place();
        var placeP = new Place();
        placeM.setName("Marseille");
        placeP.setName("Paris");

        var trip1 = new Trip();

        var placeMSaved = placeRepo.save(placeM);
        var placePSaved = placeRepo.save(placeP);
        trip1.setPlaces(Set.of(placeM, placeP));
        tripRepo.save(trip1);
        placeMSaved.setTrips(Set.of(trip1));
        placePSaved.setTrips(Set.of(trip1));
        placeRepo.save(placeMSaved);
        placeRepo.save(placePSaved);
    }

    @GetMapping("/trips")
    private Iterable<Trip> getAllTrips(){
        return tripRepo.findAll();
    }

    @GetMapping("/places")
    private Iterable<Place> getPlaces(@RequestParam(value = "id", required = false) Integer id){
        if(id == null)
            return placeRepo.findAll();
        else
            return placeRepo.findPlacesByTrips_id(id);
    }


}

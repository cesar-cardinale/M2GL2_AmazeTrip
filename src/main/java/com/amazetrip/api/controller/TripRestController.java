package com.amazetrip.api.controller;
import com.amazetrip.api.dao.CommentRepo;
import com.amazetrip.api.dao.PlaceRepo;
import com.amazetrip.api.dao.TripRepo;
import com.amazetrip.api.model.Comment;
import com.amazetrip.api.model.Place;
import com.amazetrip.api.model.Trip;
import org.aspectj.weaver.Iterators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

@RestController
@RequestMapping("/amazetrip/api")
public class TripRestController {
    @Autowired
    TripRepo tripRepo;
    @Autowired
    PlaceRepo placeRepo;

    @Autowired
    CommentRepo commentRepo;

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

    @GetMapping("/place/{idP}")
    private Place getTripFromId(@PathVariable Integer idP){
        return placeRepo.findById(idP).get();
    }

    @GetMapping("/places")
    private Iterable<Place> getPlaces(@RequestParam(value = "id", required = false) Integer id){
        if(id == null)
            return placeRepo.findAll();
        else
            return placeRepo.findPlacesByTrips_id(id);
    }

    @GetMapping("/place/{idP}/comments")
    private Iterable<Comment> getCommentsFromPlace(@PathVariable(value ="idP", required = false) Integer idP){
        if(idP == null)
            return commentRepo.findAll();
        else
            return commentRepo.findCommentsByPlace_Id(idP);
    }

    @GetMapping("/place/comments/number")
    private Integer getNumberOfCommentsForPlaces(){
        var res = getCommentsFromPlace(null);
        var wrapperNb = new Object(){int count = 0;};
        res.forEach(c->{wrapperNb.count+=1;});
        return wrapperNb.count;
    }

    @GetMapping("/place/{idP}/comments/number")
    private Integer getNumberOfCommentsForPlace(@PathVariable Integer idP){
        var res = getCommentsFromPlace(idP);
        var wrapperNb = new Object(){int count = 0;};
        res.forEach(c->{wrapperNb.count+=1;});
        return wrapperNb.count;
    }

}

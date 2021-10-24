package com.amazetrip.api.controller;
import com.amazetrip.api.dao.CommentRepo;
import com.amazetrip.api.dao.PlaceRepo;
import com.amazetrip.api.dao.TripRepo;
import com.amazetrip.api.dao.UserRepo;
import com.amazetrip.api.model.Comment;
import com.amazetrip.api.model.Place;
import com.amazetrip.api.model.Trip;
import com.amazetrip.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.lang.reflect.Array;
import java.security.Principal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("/amazetrip/api")
public class TripRestController {
    @Autowired
    TripRepo tripRepo;
    @Autowired
    PlaceRepo placeRepo;
    @Autowired
    CommentRepo commentRepo;
    @Autowired
    UserRepo userRepo;

    //To populate the bdd to do visual test.
    @PostConstruct
    private void populateTripTable(){
        var placeM = new Place();
        var placeP = new Place();
        placeM.setName("Marseille");
        placeP.setName("Paris");

        var trip1 = new Trip();

        trip1.setCreationDate(new Date());

        var placeMSaved = placeRepo.save(placeM);
        var placePSaved = placeRepo.save(placeP);
        trip1.setPlaces(List.of(placeM, placeP));
        tripRepo.save(trip1);
        placeMSaved.setTrips(Set.of(trip1));
        placePSaved.setTrips(Set.of(trip1));
        placeRepo.save(placeMSaved);
        placeRepo.save(placePSaved);
        var user = new User();
        user.setFirstname("Roselyne");
        user.setLastname("BBB");
        user.setEmail("AAA@mail.fr");
        userRepo.save(user);
        var comment = new Comment();
        comment.setUser(user);
        comment.setPlace(placeMSaved);
        comment.setCommentText("une belle ville, de belles calanques à visiter");
        comment.setCreationDate(new Date());
        commentRepo.save(comment);
        comment = new Comment();
        comment.setUser(user);
        comment.setPlace(placePSaved);
        comment.setCommentText("une belle ville, de nombreux lieux à visiter : Louvre, Tour Eiffel ...");
        comment.setCreationDate(new Date());
        commentRepo.save(comment);
    }

    @GetMapping("/trips")
    private Iterable<Trip> getAllTrips(){
        return tripRepo.findAll();
    }

    @GetMapping("/searchtrips/{placename}")
    private Iterable<Trip> getTripsWithPlace(@PathVariable String placename){
        var allTrips = tripRepo.findAll();
        LinkedList<Trip> requestedList = new LinkedList<>();
        for (Trip trip:allTrips
             ) {
            for (Place place: trip.getPlaces()
                 ) {
                if (place.getName().equals(placename)){
                    System.out.println(placename);
                    requestedList.add(trip);
                    break;
                }
            }
        }
        return requestedList;
    }

    @PostMapping("/newTrip")
    public Iterable<Trip> postTrip(@RequestBody List<String> places, Principal principal) {
        System.out.println("JE SUIS LA");

        User user = userRepo.findUserByEmail(principal.getName());

        Place pDep = new Place();
        Place pArr = new Place();

        if (pDep.getName() == null) {
            pDep = new Place();
            pDep.setName(places.get(0));
        }
        if (pArr.getName() == null) {
            pArr = new Place();
            pArr.setName(places.get(1));
        }
        placeRepo.save(pArr);
        placeRepo.save(pDep);

        Trip newTrip = new Trip();

        newTrip.setUser(user);
        newTrip.setPlaces(new LinkedList<>());
        newTrip.getPlaces().add(pDep);
        newTrip.getPlaces().add(pArr);
        newTrip.setCreationDate(new Date());
        tripRepo.save(newTrip);
        return tripRepo.findAll();
    }
}

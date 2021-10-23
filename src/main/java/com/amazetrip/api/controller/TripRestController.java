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
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.Date;
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

        var placeMSaved = placeRepo.save(placeM);
        var placePSaved = placeRepo.save(placeP);
        trip1.setPlaces(Set.of(placeM, placeP));
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


}

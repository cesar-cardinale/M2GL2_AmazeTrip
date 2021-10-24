package com.amazetrip.api.controller;
import com.amazetrip.api.dao.CommentRepo;
import com.amazetrip.api.dao.PlaceRepo;
import com.amazetrip.api.model.Comment;
import com.amazetrip.api.model.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/amazetrip/api")
public class PlaceRestController {

    @Autowired
    private PlaceRepo placeRepo;
    @Autowired
    private CommentRepo commentRepo;

    @GetMapping("/places")
    private Iterable<Place> getPlaces(@RequestParam(value = "id", required = false) Integer id){
        if(id == null)
            return placeRepo.findAll();
        else
            return placeRepo.findPlacesByTrips_id(id);
    }

    @PostMapping("/places")
    private Place addNewPlace(@RequestBody Place place){
        var res = placeRepo.save(place);
        return res;
    }

    @GetMapping("/place/{idP}")
    private Place getTripFromId(@PathVariable Integer idP){
        return placeRepo.findById(idP).get();
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

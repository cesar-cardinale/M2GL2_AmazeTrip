package com.amazetrip.app.controller;

import com.amazetrip.api.dao.PlaceRepo;
import com.amazetrip.api.dao.TripRepo;
import com.amazetrip.api.model.Place;
import com.amazetrip.api.model.Trip;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Set;

/**
 * Un contrôleur pour gérer les trajets.
 */

@Controller()
@RequestMapping("/app")
public class TripController {

    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    ServletContext context;

    @Autowired
    TripRepo tripRepo;

    @PostConstruct
    public void init() {
        System.out.println("Start " + this);
    }

    @PreDestroy
    public void destroy() {
    }

    /**
     * Montrer les trajets (GET)
     */
    @RequestMapping(value = "/trips")
    private ModelAndView getTrips(HttpServletRequest request) {
       var res = new ModelAndView("trips");
       var trips = tripRepo.findAll();
       res.addObject("trips", trips);
        return res;
    }

    @GetMapping(value = "/places")
    private String getPlace(){
        return "place";
    }

    @GetMapping(value = "/newtrip")
    private String getCreateTrip(){
        return "createTrip";
    }

}

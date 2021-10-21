package com.amazetrip.app.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

/**
 * Un contrôleur pour gérer les trajets.
 */

@Controller()
@RequestMapping("/app")
public class TripController {

    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    ServletContext context;

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
    private ModelAndView getMovies(HttpServletRequest request) {
        //HttpSession session = request.getSession();
        //session.setAttribute("isBefore2000", false);
       var res = new ModelAndView("trips");
       res.addObject("trips", null);
        return res;
    }


    @GetMapping(value = "/places?id=")
    private ModelAndView getPlace(@RequestParam int id){

        return new ModelAndView("placedetails");
    }

}

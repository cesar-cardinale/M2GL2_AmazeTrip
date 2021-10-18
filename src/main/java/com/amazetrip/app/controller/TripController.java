package com.amazetrip.app.controller;

import com.amazetrip.app.dao.TripRepository;
import com.amazetrip.app.model.Trip;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Un contrôleur pour gérer les trajets.
 */
@Controller()
public class TripController {

    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    TripRepository dao;

    @Autowired
    ServletContext context;

    @PostConstruct
    public void init() {
        System.out.println("Start " + this);
        if (dao.count() == 0) {

        }
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
        res.addObject("trips", dao.findAll());
        return res;
    }
}

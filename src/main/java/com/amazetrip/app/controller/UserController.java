package com.amazetrip.app.controller;

import com.amazetrip.api.dao.UserRepo;
import com.amazetrip.api.model.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletContext;
import java.security.Principal;

@Controller()
@RequestMapping("/app")
public class UserController {
    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    ServletContext context;

    @Autowired
    UserRepo userRepo;

    @PreDestroy
    public void destroy() {
    }

    @RequestMapping(value = "/users")
    private ModelAndView getUsers(){
        var res = new ModelAndView("users");
        res.addObject("users", userRepo.findAll());
        return res;
    }

    @RequestMapping("/profil/{id}")
    private ModelAndView getProfil(@PathVariable int id){
        var user = userRepo.findById(id).get();
        var res = new ModelAndView("profil");
        res.addObject("profil", user);
        return res;
    }

    @RequestMapping("/profil")
    private ModelAndView getCurrentProfil(Principal principal){
        var user = userRepo.findByEmail(principal.getName());
        var res = new ModelAndView("profil");
        res.addObject("profil", user);
        return res;
    }

    @GetMapping("/users/create")
    private String createUser(){
        return "create-account";
    }
}

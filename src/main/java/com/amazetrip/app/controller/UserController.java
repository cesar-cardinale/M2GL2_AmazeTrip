package com.amazetrip.app.controller;

import com.amazetrip.api.dao.UserRepo;
import com.amazetrip.api.model.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletContext;

@Controller()
@RequestMapping("/app")
public class UserController {
    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    ServletContext context;

    @Autowired
    UserRepo userRepo;

    @PostConstruct
    public void init() {
        System.out.println("Start " + this);
        if (userRepo.count() == 0) {
            userRepo.save(new User("Durand", "Nicolas", "nicolas@gmail.com", "nicolas123"));
            userRepo.save(new User("Roman", "Benoit", "benoit@yahoo.com", "benoit123"));
            userRepo.save(new User("Hexa", "Alex", "alex@hotmail.fr", "alex123"));
        }
    }

    @PreDestroy
    public void destroy() {
    }

    /**
     *  Afficher la liste d'utilisateurs
     */
    @RequestMapping("/users")
    private ModelAndView getUsers(){
        var res = new ModelAndView("users");
        res.addObject("users", null);
        return res;
    }

    /**
     *  Afficher le profil
     */
    @RequestMapping("/profil/{id}")
    private ModelAndView getProfil(@ModelAttribute User user){
        var res = new ModelAndView("profil");
        res.addObject("profil", user);
        return res;
    }

    /**
     *  Affiche la page de création d'un utilisateur
     */
    @GetMapping("/users/create")
    private String createUser(){
        return "create-account";
    }
}

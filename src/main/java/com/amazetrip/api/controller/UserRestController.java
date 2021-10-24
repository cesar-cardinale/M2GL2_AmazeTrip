package com.amazetrip.api.controller;

import com.amazetrip.api.dao.UserRepo;
import com.amazetrip.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class UserRestController {
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

    @RequestMapping("/users")
    public Iterable<User> getUsers(){
        return userRepo.findAll();
    }

    @RequestMapping("/users/{id}")
    public User getProfil(@PathVariable int id){
        return userRepo.findById(id).get();
    }

    @PostMapping("/users/create")
    public User postUser(@Valid @RequestBody User u){
        userRepo.save(u);
        return u;
    }
}

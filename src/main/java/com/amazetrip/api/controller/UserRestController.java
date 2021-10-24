package com.amazetrip.api.controller;

import com.amazetrip.api.dao.UserRepo;
import com.amazetrip.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class UserRestController {
    @Autowired
    UserRepo userRepo;

    @Autowired
    PasswordEncoder encoder;

    @PostConstruct
    public void init() {
        System.out.println("Start " + this);
        userRepo.save(new User("Durand", "Nicolas", "nicolas@gmail.com", encoder.encode("nicolas123")));
        userRepo.save(new User("Roman", "Benoit", "benoit@yahoo.com", encoder.encode("benoit123")));
        userRepo.save(new User("Hexa", "Alex", "alex@hotmail.fr", encoder.encode("alex123")));
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
    public HttpStatus postUser(@Valid @RequestBody User u){
        u.setPassword(encoder.encode(u.getPassword()));
        userRepo.save(u);
        return HttpStatus.CREATED;
    }
}

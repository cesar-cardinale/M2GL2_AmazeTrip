package com.amazetrip.api.dao;

import com.amazetrip.api.model.User;
import org.springframework.data.repository.CrudRepository;

import java.awt.*;

public interface UserRepo extends CrudRepository<User, Integer> {

    User findUserByFirstname(String Lastname);
    User findUserByEmail(String email);
    User findByEmail(String email);

}

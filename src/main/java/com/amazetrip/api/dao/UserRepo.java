package com.amazetrip.api.dao;

import com.amazetrip.api.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Integer> {

}

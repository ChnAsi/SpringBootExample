package com.dataservice.usersdb.Repository;

import com.dataservice.usersdb.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface UsersRepository extends MongoRepository<User, String> {

    public User findByName(String name);
    //public User find(String id);
    public User deleteByid(String id);
}

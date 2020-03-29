package com.dataservice.usersdb.contractors;

import com.dataservice.usersdb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;


public interface UserContractor {


    public List<User> getAllUsers(Boolean sorted);

    public List<String> getAllUsersNames(Boolean sorted);

    public User addUser(User user);

    public void addMultipleUsers(List<User> user);

    public User getUser(String id);


}

package com.dataservice.usersdb.contractors;

import com.dataservice.usersdb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.*;

@Service
public class ExampleUserContractor implements UserContractor{

    private final RestTemplate restTemplate;

    @Autowired
    public ExampleUserContractor(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }


    @Override
    public User getUser(String id) {
        String url = String.format("http://localhost:8081/user-details?uuid=%s", id);
        ResponseEntity<User> response = this.restTemplate.getForEntity(url, User.class, 1);
        if(response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        }
        return null;
    }

    @Override
    public List<User> getAllUsers(Boolean sorted) {
        String url = String.format("http://localhost:8081//all-users?sorted=%b", sorted);
        ResponseEntity<User[]> response = this.restTemplate.getForEntity(url, User[].class, 1);
        if(response.getStatusCode() == HttpStatus.OK) {
            return Arrays.asList(response.getBody());
        }
        return null;
    }

    @Override
    public List<String> getAllUsersNames(Boolean sorted) {
        String url = String.format("http://localhost:8081/users-names?sorted=%b", sorted);
        ResponseEntity<String[]> response = this.restTemplate.getForEntity(url, String[].class, 1);
        if(response.getStatusCode() == HttpStatus.OK) {
            return Arrays.asList(response.getBody());
        }
        return null;
    }

    @Override
    public User addUser(User user) {

        System.out.println("ExampleUserContractor: addUser: " + user);

        String url = "http://localhost:8081/add-user";

        // send POST request
        ResponseEntity<User> response = this.restTemplate.postForObject(url, user, ResponseEntity.class);

        // check response status code
        if (response.getStatusCode() == HttpStatus.CREATED) {
            return response.getBody();
        } else {
            return null;
        }
    }


    @Override
    public void addMultipleUsers(List<User> user) {

    }


}

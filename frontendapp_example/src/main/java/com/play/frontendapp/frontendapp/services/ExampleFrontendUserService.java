package com.play.frontendapp.frontendapp.services;


import com.dataservice.usersdb.contractors.ExampleUserContractor;
import com.dataservice.usersdb.contractors.UserContractor;
import com.dataservice.usersdb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExampleFrontendUserService implements FrontendUserService {

    UserContractor contractor;

    @Autowired
    public ExampleFrontendUserService(UserContractor contractor) {
        this.contractor = contractor;
    }

    public List<User> getAllUsers(Boolean sorted){
        return contractor.getAllUsers(sorted);
    }

    public List<String> getAllUsersNames(Boolean sorted){
        return contractor.getAllUsersNames(sorted);
    }

    public User addUser(String name, String lastName, int birthYear){

        User user = new User();
        user.setName(name);
        user.setLastName(lastName);
        user.setBirthYear(birthYear);
        return contractor.addUser(user);
    }

    public void addMultipleUsers(List<User> user){

        contractor.addMultipleUsers(user);
        contractor = new ExampleUserContractor(null);
    }

    public User getUser(String id){
        return contractor.getUser(id);
    }

}

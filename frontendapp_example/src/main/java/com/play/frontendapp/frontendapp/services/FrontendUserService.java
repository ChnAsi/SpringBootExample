package com.play.frontendapp.frontendapp.services;


import com.dataservice.usersdb.model.User;

import java.util.List;

public interface FrontendUserService {

    public List<User> getAllUsers(Boolean sorted);

    public List<String> getAllUsersNames(Boolean sorted);

    public User addUser(String name, String lastName, int birthYear);

    public void addMultipleUsers(List<User> user);

    public User getUser(String id);

}
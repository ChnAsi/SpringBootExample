package com.dataservice.usersdb.services;

import com.dataservice.usersdb.model.User;
import java.util.List;

public interface UserService {

    public List<User> getAllUsers(Boolean sorted);

    public List<String> getAllUsersNames(Boolean sorted);

    public User addUser(User user);

    public void addMultipleUsers(List<User> user);

    public User getUser(String id);

    public User findByName(String name);

    public User delete(String id);

}

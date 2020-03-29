package com.dataservice.usersdb.services;

import com.dataservice.usersdb.Repository.UsersRepository;
import com.dataservice.usersdb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExampleUserService implements UserService {

    UsersRepository repo;

    // Loader to load the users data from disk.
    DataLoader dataLoader;

    @Autowired
    public ExampleUserService(UsersRepository repo, DataLoader dataLoader) {
        System.out.println("UserService()");
        this.repo = repo;
        this.dataLoader = dataLoader;

        // If we do have a data loader it means that data should be loaded from disk.
        if (this.dataLoader != null) {
            List<User> users = this.dataLoader.loadJsonFromDisk();
            if (users != null) {
                addMultipleUsers(users);
            } else {
                System.err.println("Couldn't load any data from disk.");
            }
        }
        else {
            System.err.println("No DataLoader is available.");
        }
    }

    public List<User> getAllUsers(Boolean sorted){
        if (sorted) {
            return (List<User>) repo.findAll(Sort.by(Sort.Direction.ASC, "birthYear"));
        }
        // Else.
        return (List<User>) repo.findAll();
    }

    public List<String> getAllUsersNames(Boolean sorted){
        // Get all users.
        List<User> allUsers = (List<User>) repo.findAll(Sort.by(Sort.Direction.ASC, "birthYear"));

        // Extract users names.
        List<String> names = new ArrayList<>();
        for (User usr : allUsers){
            names.add(usr.getName());
        }

        return names;
    }

    public User addUser(User user){
        return repo.save(user);
    }

    public void addMultipleUsers(List<User> user){
        repo.saveAll(user);
    }

    public User getUser(String id){
        Optional<User> opt = repo.findById(id);
        if (opt.isPresent()){
            return opt.get();
        }
        return null;
    }


    public User findByName(String name) {
        return (User)repo.findByName(name);
    }

    public User delete(String id) {
        return (User)repo.deleteByid(id);
    }

}

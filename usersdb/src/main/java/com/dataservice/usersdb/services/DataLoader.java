package com.dataservice.usersdb.services;

import com.dataservice.usersdb.model.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DataLoader {

    public List<User> loadJsonFromDisk();

}

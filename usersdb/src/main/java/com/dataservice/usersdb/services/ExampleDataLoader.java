package com.dataservice.usersdb.services;

import com.dataservice.usersdb.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class ExampleDataLoader implements DataLoader {

    @Override
    public List<User> loadJsonFromDisk() {

        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<User>> typeReference = new TypeReference<List<User>>(){};
        InputStream inputStream = TypeReference.class.getResourceAsStream("/Jsons/users.json");

        List<User> users = null;

        try {
            if (inputStream != null) {
                users = mapper.readValue(inputStream, typeReference);
            }

        } catch (IOException e) {

            e.printStackTrace();

        }

        for (User user : users){
            System.out.println(user.getName());
        }

        return users;    }
}

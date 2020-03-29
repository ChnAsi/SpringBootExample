package com.dataservice.usersdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class UsersdbApplication {

    public static void main(String[] args) {

        System.out.println("UsersdbApplication : Application start");

        ApplicationContext context = SpringApplication.run(UsersdbApplication.class, args);

        System.out.println("UsersdbApplication : Application after init");

//        ExampleUserContractor userContractor = new ExampleUserContractor(new RestTemplateBuilder());
//
//        User user = userContractor.getUser("3d1921a9-35e6-493f-915b-0d3ab5fe8e94");
//
//        System.out.println("Creating new user for: " + user);
//
//        List<String> usersNames = userContractor.getAllUsersNames(true);
//
//        System.out.println(usersNames);
//
//        List<User> users = userContractor.getAllUsers(true);
//
//        System.out.println(users);
//
//        System.out.println(userContractor.addUser(user));

    }



}

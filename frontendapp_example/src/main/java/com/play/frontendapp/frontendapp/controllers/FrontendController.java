package com.play.frontendapp.frontendapp.controllers;

import com.dataservice.usersdb.model.User;
import com.play.frontendapp.frontendapp.services.FrontendUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FrontendController {

    private FrontendUserService userService;

    @Autowired
    public FrontendController(FrontendUserService userService) {
        System.out.println("FrontendController:FrontendController()");
        this.userService = userService;
    }

    @RequestMapping("/")
    public String index(){
        return "Whatsuuupppp";
    }

    @GetMapping("/user-details")
    public User getUserDetails(@RequestParam(value = "uuid") String uuid){
        System.out.println("Received Get request [user-details] uuid = " + uuid);
        return userService.getUser(uuid);
    }

    @GetMapping("/users-names")
    public List<String> getAllUsersNames(@RequestParam(required = false) Boolean sorted){
        System.out.println("Received Get request [users-names] sorted = " + sorted);
        return userService.getAllUsersNames(sorted);
    }

    @PostMapping("/add-user")
    public User addUser(@RequestParam String name, @RequestParam String lastName, @RequestParam int birthYear){
        System.out.println("Received Post request [add-user] name = " + name + ". lastName = " + lastName + ". birthYear = " + birthYear);
        return userService.addUser(name, lastName, birthYear);
    }

    // @brief Map ".../all-users" Get request.
    // @param sorted [Boolean] - A flag for retrieving sorted list.
    @PostMapping("/all-users")
    public List<User> getAllUsers(@RequestParam Boolean sorted){
        return userService.getAllUsers(sorted);
    }

}

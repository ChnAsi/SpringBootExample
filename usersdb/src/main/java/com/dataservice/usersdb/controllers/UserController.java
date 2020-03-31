package com.dataservice.usersdb.controllers;

import com.dataservice.usersdb.model.User;
import com.dataservice.usersdb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.List;


@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        System.out.println("UserController:UserController()");
        this.userService = userService;
    }

    @RequestMapping("/")
    public String index(){
        return "Whatsuuupppp";
    }

    @GetMapping("/user-details")
    public User getUserDetails(@RequestParam(value = "uuid") String uuid){
        System.out.println("looking for uid = " + uuid);
        return userService.getUser(uuid);
    }

    @GetMapping("/users-names")
    public List<String> getAllUsersNames(@RequestParam(required = false) Boolean sorted){
        System.out.println("retrieving all names (sorted = " + sorted + ")");
        return (List<String>) userService.getAllUsersNames(sorted);
    }

    @PostMapping("/add-user")
    //public User addUser(@RequestParam String name,@RequestParam String lastName,@RequestParam int birthYear){
    public User addUser(@RequestParam User user){
        System.out.println("Creating new user for: name = " + user.getName() + " last name = " + user.getLastName() + " birthYear = " + user.getBirthYear());

        return userService.addUser(user);
    }

    // @brief Map ".../all-users" Get request.
    // @param sorted [Boolean] - A flag for retrieving sorted list.
    @GetMapping("/all-users")
    public List<User> getAllUsers(@RequestParam Boolean sorted){
        return userService.getAllUsers(sorted);
    }


    //--------------------------------
    //--------- Utils Funcs ----------
    //--------------------------------

    private String generateUserId(String temporaryIdentifier){

        final MessageDigest digest;
        String uuid = null;

        try {
            digest = MessageDigest.getInstance("SHA-256");
            final byte[] hashbytes = digest.digest(
                    temporaryIdentifier.getBytes(StandardCharsets.UTF_8));
            uuid = convertBytesToHex(hashbytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return uuid;
    }

    public static String convertBytesToHex(byte[] bytes) {

        StringBuilder result = new StringBuilder();

        for (byte temp : bytes) {

            int decimal = (int) temp & 0xff;  // bytes widen to int, need mask, prevent sign extension

            String hex = Integer.toHexString(decimal);

            result.append(hex);

        }
        return result.toString();


    }
}

package com.bancaVirtual.apiBanca.controller;

import com.bancaVirtual.apiBanca.UserService;
import com.bancaVirtual.apiBanca.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.createuser(user);
    }

    @GetMapping("{id}")
    public User searchUserById(@PathVariable("id") UUID id){
        return userService.getUserById(id);
    }
    @DeleteMapping("{id}")
    public void deleteUserById(@PathVariable("id") UUID id){
        userService.deleteUser(id);
    }
        @GetMapping("search")
        public User searchUserByEmailAndPassword(
                @RequestParam("email") String email,
                @RequestParam("password") String password) {
            System.out.println("Searching for user by email and password");
            User user = userService.getUserByEmailAndPassword(email, password);
            System.out.println("Found user: " + user);
            return user;
        }
    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

}


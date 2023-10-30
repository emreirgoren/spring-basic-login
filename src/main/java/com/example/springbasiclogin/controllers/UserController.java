package com.example.springbasiclogin.controllers;

import com.example.springbasiclogin.entities.User;
import com.example.springbasiclogin.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/createUser")
    public User createUser(@RequestBody User newUser) {
        return userService.createUser(newUser);
    }

    @GetMapping("/login/{username}/{password}")
    public String login(@PathVariable String username, @PathVariable String password) {
        return userService.login(username, password);
    }

}

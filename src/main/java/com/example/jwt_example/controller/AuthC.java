package com.example.jwt_example.controller;

import com.example.jwt_example.model.Users;
import com.example.jwt_example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthC {
    @Autowired
    private UserService userService;

    @PostMapping("/logout")
    public String logout() {
        return "login page";
    }

    @PostMapping("/login")
    public String login(@RequestBody Users user) {
        return userService.verify(user);
    }
}

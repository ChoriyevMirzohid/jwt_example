package com.example.jwt_example.controller;

import com.example.jwt_example.model.Users;
import com.example.jwt_example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class LoginC {
    @Autowired
    private UserService userService;

    @GetMapping("/sign-in")
    public String getPage(){
        return "sign-in";
    }
}

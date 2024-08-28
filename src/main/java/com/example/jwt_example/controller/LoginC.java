package com.example.jwt_example.controller;

import com.example.jwt_example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginC {
    @Autowired
    private UserService userService;

    @GetMapping("/sign-in")
    public String getPage(){
        return "sign-in";
    }
}

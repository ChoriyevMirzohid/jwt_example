package com.example.jwt_example.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/")
    public String getText(HttpServletRequest request){
        return "ID: " + request.getSession().getId();
    }

}

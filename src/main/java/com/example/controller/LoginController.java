package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.data.entity.LoginRequest;
import com.example.data.service.UserService;


@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping("/auth/login")
    public String login() {
        return "auth/login";
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> loginAuthentication(@RequestParam String username, @RequestParam String password) {
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);

        LoginRequest loginRequest = new LoginRequest(username, password);
        boolean isAuthentize =  userService.LoginRequestAuthentication(loginRequest);
        System.out.println("isAuthentize: " + isAuthentize);

        return ResponseEntity.ok(isAuthentize);    
    }
}


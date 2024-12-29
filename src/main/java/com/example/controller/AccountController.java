package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.data.service.UserService;


@Controller
public class AccountController {

    @Autowired
    UserService userService;

    /*
     * Add the user info to the profile page for editing 
     */
    @GetMapping("/user/profile")
    public String getUserInfo(@RequestParam String username, Model model) {

        model.addAttribute("User", userService.getUserByUsername(username));

        return "auth/profile";
    }
}

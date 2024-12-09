package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.data.service.CustomerService;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/index")
    /**
     * Handles requests to the /index endpoint.
     *
     * @param model the model to which the list of customers is added
     * @return the name of the Thymeleaf template (index.html)
     */
    public String index(Model model) {

        // Add the list to the model
        model.addAttribute("customers", customerService.findAll());

        // Return the name of the Thymeleaf template (index.html)
        return "index";
    }
}

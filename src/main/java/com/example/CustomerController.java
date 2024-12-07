package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CustomerController {

    @GetMapping("/index")
    public String user(Model model) {
        // Create a list of customers
        List<Customer> customers = List.of(
            new Customer(1L, "Alice", "123 Main St", "555-1234"),
            new Customer(2L, "Bob", "456 Elm St", "555-4567"),
            new Customer(3L, "Charlie", "789 Maple St", "555-7890")
        );

        // Add the list to the model
        model.addAttribute("customers", customers);

        // Return the name of the Thymeleaf template (index.html)
        return "index";
    }
}

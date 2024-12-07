package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    private static final Logger logger = LoggerFactory.getLogger(GreetingController.class); // Correct logger type

    @GetMapping("/greet")
    public String greet(@RequestParam String name) {
        logger.info("Received name: {}", name); // Log the name
        String greeting = "Hello, " + name + "!";
        logger.info("Returning greeting: {}", greeting); // Log the greeting
        return greeting;
    }
}

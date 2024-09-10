package com.example.ConfigClient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/readprops")
public class ConfigClientController {

    @Value("${server.port.key}")  // Corrected the property key syntax
    private String serverPort;

    @Value("${spring.application.name}")
    private String appName;

    @GetMapping("/show")  // Added a mapping annotation to the method
    public String showProps() {
        return "Port: " + serverPort + " | App Name: " + appName;
    }
}

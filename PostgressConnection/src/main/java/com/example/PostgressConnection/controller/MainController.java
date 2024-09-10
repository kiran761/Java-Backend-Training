package com.example.PostgressConnection.controller;


import com.example.PostgressConnection.model.User;
import com.example.PostgressConnection.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class MainController {

    @Autowired
    MainService service;

    @PostMapping("/add")
    public User addUser(@RequestBody User user1)
    {
        return service.addUser(user1);
    }

    @PostMapping("/validate")

    public String validateUser(@RequestBody User user1)
    {
        return service.validateUser(user1);
    }
}

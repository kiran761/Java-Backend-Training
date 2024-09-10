package com.example.BootSecurityInMemory.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @GetMapping("/get")
    public String greet()
    {
        return "working !!!!";
    }

    @GetMapping("/admin")
    public String greetAdmin() {
        return "Admin@Work";
    }

    @GetMapping("/user")
    public  String greetUser(){
        return "User@Work";
    }

}

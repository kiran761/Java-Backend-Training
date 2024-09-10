package com.example.HelloService.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/service")

public class HelloServiceController {

    @GetMapping("/hi")
    public String getAll()
    {
        return "Hello";
    }

    @GetMapping("/oddoreven/{num}")
    public String oddoreven(@PathVariable int num)
    {
        return num%2==0?"even":"odd";
    }

    @GetMapping("factorial/{num}")
    public Integer factorial(@PathVariable int num)
    {
        int fact=1;
        for(int i=1;i<=num;i++)
        {
             fact=fact*i;
        }
        return fact;
    }

}

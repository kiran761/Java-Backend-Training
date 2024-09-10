package com.example.HelloClient4j;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/client")
public class HelloServiceResource {

    @Autowired
    RestTemplate template;


    public final static String CLIENT_SERVICE="clientService";


    @GetMapping
    @CircuitBreaker(name = CLIENT_SERVICE,fallbackMethod = "callonFail")
    public String callServer()
    {
        String url="http://localhost:8094/rest/service/oddoreven/7";
        String output=template.getForObject(url,String.class);
        return output;
    }

    public String callonFail(Exception e)
    {
        return "Cant Reach.....";
    }
}

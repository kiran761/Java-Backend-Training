package com.example.HelloClient.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/client")
public class HelloClientmainController {
    @Autowired
    RestTemplate template;
    @GetMapping("/hello")
    public ResponseEntity<String> clientController()
    {
        String url="http://localhost:8070/rest/service/hi";
        ResponseEntity<String> response=template.getForEntity(url,String.class);

//        url="https://bored-api.appbrewery.com/";
//        String res=template.getForObject(url,String.class);

        return  response;
    }

    @GetMapping("/oddoreven/{num}")
    public ResponseEntity<String> oddoreven(@PathVariable int num)
    {

        String url="http://localhost:8070/rest/service/oddoreven/{num}";
        ResponseEntity<String> response=template.getForEntity(url,String.class,num);
        return response;

    }

    @GetMapping("/factorial/{num}")
     public ResponseEntity<Integer> factorial(@PathVariable int num)
    {
        String url="http://localhost:8070/rest/service/factorial/{num}";
        ResponseEntity<Integer> response=template.getForEntity(url,Integer.class,num);
        return response;
    }

}

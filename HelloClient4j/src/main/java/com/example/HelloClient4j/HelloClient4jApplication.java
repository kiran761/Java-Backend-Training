package com.example.HelloClient4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class HelloClient4jApplication {

	public static void main(String[] args) {

		SpringApplication.run(HelloClient4jApplication.class, args);
	}

	@Bean
	public RestTemplate newTemplate()
	{
		return new RestTemplate();
	}
}

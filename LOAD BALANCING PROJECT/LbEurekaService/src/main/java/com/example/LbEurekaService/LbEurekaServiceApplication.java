package com.example.LbEurekaService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class LbEurekaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LbEurekaServiceApplication.class, args);
	}

}

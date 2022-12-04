package com.payment.keycloack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class KeycloackApplication {

	public static void main(String[] args) {
		SpringApplication.run(KeycloackApplication.class, args);
	}

}

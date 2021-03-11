package com.ddr.docker.netflix.spring.microservices.greetingstelegram;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class GreetingsTelegramApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreetingsTelegramApplication.class, args);
	}

}

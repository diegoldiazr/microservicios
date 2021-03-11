package com.ddr.docker.netflix.spring.microservices.greetingstelegram.controllers;

import com.ddr.docker.netflix.spring.microservices.greetingstelegram.interfaces.IGreetingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    IGreetingService greetingService;
 
    public GreetingController(@Autowired IGreetingService greetingService) {
        this.greetingService=greetingService;
    }
 
    @GetMapping("/greet")
    public String getGreeting() throws Exception {
        return greetingService.getServiceGreeting();
    }
}

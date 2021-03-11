package com.ddr.docker.netflix.spring.microservices.greetingstelegram.impl;

import com.ddr.docker.netflix.spring.microservices.greetingstelegram.interfaces.IGreetingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements IGreetingService{


    @Autowired
    private Environment env;

    @Override
    public String getServiceGreeting() throws Exception {
        String portValue = env.getProperty("server.port");
        String returnValue = "Something unexpected happened, no greeting for you";
        if(portValue!= null && !portValue.isEmpty()) {
            returnValue = new StringBuilder().append("Hello, since greet-telegram from port: ").append(portValue).append("n").toString();
        }
        return returnValue;
    }
    
}

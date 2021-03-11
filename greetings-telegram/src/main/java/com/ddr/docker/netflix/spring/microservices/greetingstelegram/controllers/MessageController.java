package com.ddr.docker.netflix.spring.microservices.greetingstelegram.controllers;

import com.ddr.docker.netflix.spring.microservices.greetingstelegram.interfaces.IMessageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    
    IMessageService messageService;
 
    public MessageController(@Autowired IMessageService messageService) {
        this.messageService=messageService;
    }
 
    @GetMapping("/config")
    public String getConfig() throws Exception {
        return messageService.getConfig();
    }
}

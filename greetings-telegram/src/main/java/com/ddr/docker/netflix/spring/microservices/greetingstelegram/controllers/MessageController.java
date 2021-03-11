package com.ddr.docker.netflix.spring.microservices.greetingstelegram.controllers;

import com.ddr.docker.netflix.spring.microservices.greetingstelegram.interfaces.IMessageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    
    IMessageService messageService;
 
    public MessageController(@Autowired IMessageService messageService) {
        this.messageService=messageService;
    }


    @GetMapping("/version")
    public String getVersion() throws Exception {
        return messageService.getVersion();
    }

    @GetMapping("/message/{text}")
    public String getMessage(@PathVariable String text) throws Exception {
        return messageService.getMessage(text);
    }
}

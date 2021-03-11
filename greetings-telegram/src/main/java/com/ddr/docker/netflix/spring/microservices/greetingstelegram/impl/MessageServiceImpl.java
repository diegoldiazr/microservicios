package com.ddr.docker.netflix.spring.microservices.greetingstelegram.impl;

import com.ddr.docker.netflix.spring.microservices.greetingstelegram.interfaces.IMessageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements IMessageService {

    @Autowired
    private Environment env;

    @Override
    public String getConfig() throws Exception {
        String url = env.getProperty("telegram.url");
        String apiToken = env.getProperty("telegram.apiToken");
        String chatId = env.getProperty("telegram.chatId");
        String returnValue = "Something unexpected happened, no greeting for you";
        if(url!= null && !url.isEmpty()) {
            returnValue = new StringBuilder().append("Configure from greetings-telegram.  ")
            .append(url).append("n").append(apiToken).append("n").append(chatId).append("n").toString();
        }
        return returnValue;
    }
    
}

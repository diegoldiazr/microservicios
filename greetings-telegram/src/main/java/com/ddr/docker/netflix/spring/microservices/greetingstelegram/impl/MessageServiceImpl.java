package com.ddr.docker.netflix.spring.microservices.greetingstelegram.impl;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.ddr.docker.netflix.spring.microservices.greetingstelegram.interfaces.IMessageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements IMessageService {

    @Autowired
    private Environment env;

    @Override
    public String getVersion() throws Exception{
        String version = env.getProperty("spring.application.version");
        String returnValue = "Something unexpected happened, no greeting for you";
        if(version!= null && !version.isEmpty()) {
            returnValue = new StringBuilder().append("Version: ")
            .append(version).append("\n").toString();
        }
        return returnValue;
    }

    @Override
    public String getMessage(String text) throws Exception {
        String url = env.getProperty("telegram.url");
        String apiToken = env.getProperty("telegram.apiToken");
        String chatId = env.getProperty("telegram.chatId");

        return sendTelegramMessage(url, apiToken, chatId, text);
            
    }

    
    private String sendTelegramMessage(String url, String apiToken, String chatId, String text) throws Exception{
            
        String response = new String();
        
        try {
            url = String.format(url, apiToken, chatId, text);   
            URL urlWeb;
            urlWeb = new URL(url);
            URLConnection conn = urlWeb.openConnection();
    
            StringBuilder sb = new StringBuilder();
            InputStream is = new BufferedInputStream(conn.getInputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String inputLine = "";
            while ((inputLine = br.readLine()) != null) {
                sb.append(inputLine);
            }
            response = sb.toString();
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // Do what you want with response
        catch (IOException e) {
            // TODO Auto-generated catch block
             e.printStackTrace();
        }
        return response;
    }


    
}

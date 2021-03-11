package com.ddr.docker.netflix.spring.microservices.greetingstelegram.interfaces;

public interface IMessageService {

    String getVersion() throws Exception;

    String getMessage(String text) throws Exception;
}

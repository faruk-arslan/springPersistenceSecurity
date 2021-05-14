package com.udacity.jwdnd.c1.review;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class MessageService {
    private String message;

    public MessageService(String message){
        this.message=message;
    }

    public String returnUpperCase(){
        return message.toUpperCase();
    }
    public String returnLowerCase(){
        return message.toLowerCase();
    }
    @PostConstruct
    public void postConstruct(){
        System.out.println("Creating message service Bean...");
    }
}

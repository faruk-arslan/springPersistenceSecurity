package com.udacity.jwdnd.c1.review.service;

import com.udacity.jwdnd.c1.review.model.ChatForm;
import com.udacity.jwdnd.c1.review.model.ChatMessage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MessageService {
//    private String message;
    private ArrayList<ChatMessage> chatMessages= new ArrayList<ChatMessage>();
//    public MessageService(ArrayList<ChatMessage> chatForm){
//        this.chatForm=chatForm;
//    }
//    public MessageService(String message){
//        this.message=message;
//    }

    public void addMessage(ChatForm chatForm){
        ChatMessage newMessage=new ChatMessage();
        switch (chatForm.getMessageType()){
            case "Shout":
                newMessage.setMessageText(chatForm.getMessageText().toUpperCase());
                break;
            case "Whisper":
                newMessage.setMessageText(chatForm.getMessageText().toLowerCase());
                break;
            default:
                newMessage.setMessageText(chatForm.getMessageText());
                break;
        }
        newMessage.setSenderUsername(chatForm.getUsername());
        chatMessages.add(newMessage);
    }

    public ArrayList<ChatMessage> getMessages(){
        return chatMessages;
    }

//    public String returnUpperCase(){
//        return message.toUpperCase();
//    }
//    public String returnLowerCase(){
//        return message.toLowerCase();
//    }
//    @PostConstruct
//    public void postConstruct(){
//        System.out.println("Creating message service Bean...");
//    }
}

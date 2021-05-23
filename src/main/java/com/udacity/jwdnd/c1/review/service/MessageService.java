package com.udacity.jwdnd.c1.review.service;

import com.udacity.jwdnd.c1.review.mapper.MessageMapper;
import com.udacity.jwdnd.c1.review.model.ChatForm;
import com.udacity.jwdnd.c1.review.model.ChatMessage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    MessageMapper messageMapper;

    public MessageService(MessageMapper messageMapper) {
        this.messageMapper = messageMapper;
    }

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
        newMessage.setUsername(chatForm.getUsername());
        messageMapper.insertMessage(newMessage);
    }

    public List<ChatMessage> getMessages(){
        return messageMapper.getAllMessages();
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

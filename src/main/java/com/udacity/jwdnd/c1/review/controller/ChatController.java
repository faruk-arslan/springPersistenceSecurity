package com.udacity.jwdnd.c1.review.controller;

import com.udacity.jwdnd.c1.review.model.ChatForm;
import com.udacity.jwdnd.c1.review.model.ChatMessage;
import com.udacity.jwdnd.c1.review.service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chat")
public class ChatController {

    private MessageService messageService;
    public ChatController(MessageService messageService){
        this.messageService=messageService;
    }

    @GetMapping
    public String serveChatPage(@ModelAttribute("message") ChatForm chatForm, Model model){
        model.addAttribute("messages", messageService.getMessages());
        return "chat";
    }

    @PostMapping
    public String chatPost(@ModelAttribute("message") ChatForm chatForm, Model model){
        messageService.addMessage(chatForm);
        chatForm.setUsername("");
        chatForm.setMessageText("");
        chatForm.setMessageType("Say");
        model.addAttribute("messages", messageService.getMessages());
        return "chat";
    }

    @ModelAttribute("checkBoxValues")
    public String[] values(){
        return new String[]{"Shout","Whisper","Say"};
    }
}

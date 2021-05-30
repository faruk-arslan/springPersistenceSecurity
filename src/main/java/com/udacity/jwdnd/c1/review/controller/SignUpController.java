package com.udacity.jwdnd.c1.review.controller;

import com.udacity.jwdnd.c1.review.mapper.UserMapper;
import com.udacity.jwdnd.c1.review.model.User;
import com.udacity.jwdnd.c1.review.model.UserForm;
import com.udacity.jwdnd.c1.review.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signup")
public class SignUpController {
    private UserService userService;

    public SignUpController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String serveSignUpPage(){ return "signup"; }

    @PostMapping
    public String signUpUser(@ModelAttribute UserForm userForm, Model model){
        // TODO: Check the availability of the username
        int rowsAdded=userService.createUser(userForm);

        return "login";
    }
}

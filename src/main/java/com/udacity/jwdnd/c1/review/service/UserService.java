package com.udacity.jwdnd.c1.review.service;

import com.udacity.jwdnd.c1.review.mapper.UserMapper;
import com.udacity.jwdnd.c1.review.model.User;
import com.udacity.jwdnd.c1.review.model.UserForm;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;

@Service
public class UserService {
    private final UserMapper userMapper;
    private final HashService hashService;

    public UserService(UserMapper userMapper, HashService hashService) {
        this.userMapper = userMapper;
        this.hashService = hashService;
    }

    public int createUser(UserForm userForm){
        // TODO: Check if the username exist
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        String encodedSalt = Base64.getEncoder().encodeToString(salt);
        String hashedPassword = hashService.getHashedValue(userForm.getPassword(), encodedSalt);

        return userMapper.insertUser(new User(5, userForm.getUsername(), encodedSalt, hashedPassword, userForm.getFirstName(), userForm.getLastName()));
    }

    public User getUser(String username){ return userMapper.getUser(username);}

    public boolean isUsernameAvailable(String username){ return userMapper.getUser(username)==null;}
}

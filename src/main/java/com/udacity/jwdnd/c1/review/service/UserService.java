package com.udacity.jwdnd.c1.review.service;

import com.udacity.jwdnd.c1.review.mapper.UserMapper;
import com.udacity.jwdnd.c1.review.model.User;
import com.udacity.jwdnd.c1.review.model.UserForm;
import org.springframework.stereotype.Service;

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
//        user.setPassword(hashService.hash(user.getPassword()));
//        user.setSalt("salt-123-salt");
//        return userMapper.insertUser(user);

        return userMapper.insertUser(new User(5, userForm.getUsername(), "encodedSalt", userForm.getPassword(), userForm.getFirstName(), userForm.getLastName()));
    }

    public User getUser(String username){ return userMapper.getUser(username);}

    public boolean isUsernameAvailable(String username){ return userMapper.getUser(username)==null;}
}

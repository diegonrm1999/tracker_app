package com.tracker.dredson.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.tracker.dredson.models.User;
import com.tracker.dredson.repositories.UserRepository;

public class UserService {
    @Autowired
    UserRepository userRepository;

    public User login(User user){
        return user;
    }
}

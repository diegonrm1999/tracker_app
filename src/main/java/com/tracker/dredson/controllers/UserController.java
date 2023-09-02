package com.tracker.dredson.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.dredson.models.User;
import com.tracker.dredson.services.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public User login(@RequestBody User user) {
        return userService.login(user);
    }
}

package com.tracker.dredson.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.dredson.models.auth.AuthLoginRequest;
import com.tracker.dredson.models.auth.AuthRegisterRequest;
import com.tracker.dredson.models.auth.AuthResponse;
import com.tracker.dredson.services.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @PostMapping(value = "login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthLoginRequest request)
    {
        return ResponseEntity.ok(userService.login(request));
    }

    @PostMapping(value = "register")
    public ResponseEntity<AuthResponse> register(@RequestBody AuthRegisterRequest request)
    {
        return ResponseEntity.ok(userService.register(request));
    }
}

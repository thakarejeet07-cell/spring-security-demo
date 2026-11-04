package com.jeet.spring_security_demo.controller;

import com.jeet.spring_security_demo.model.User;
import com.jeet.spring_security_demo.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("register")
    public User register(@RequestBody User user) {
        return service.saveUser(user);
    }
}
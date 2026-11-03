package com.jeet.spring_security_demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionController {

    @GetMapping("/session")
    public String getSessionId(HttpServletRequest request) {
        return "Session ID: " + request.getSession().getId();
    }
}

package com.jeet.spring_security_demo.controller;
import java.util.Map;
import org.springframework.security.web.csrf.CsrfToken;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class SessionController {

    @GetMapping("/session")
    public String getSessionId(HttpServletRequest request) {
        return "Session ID: " + request.getSession().getId();
    }

    @GetMapping("/csrf-token")
    public Map<String, String> getCsrfToken(CsrfToken token) {
        return Map.of(
                "parameterName", token.getParameterName(),
                "headerName", token.getHeaderName(),
                "token", token.getToken()
        );
    }
}

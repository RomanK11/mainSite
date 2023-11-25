package com.wf.site.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

import com.wf.site.models.User;
import com.wf.site.services.AuthService;

@Controller
public class AuthController {
    @GetMapping("/autorisation")
    public String getAuthPage() {
        return "autorisation";
    }
    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String authenticate(@RequestParam String username, @RequestParam String password) {
        if (authService.authenticate(username, password)) {
            return "loginSucces";
        } else {
            return "error";
        }
    }

    @ModelAttribute(name = "user")
    public User user() {
        return new User();
    }
}

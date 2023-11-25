package com.wf.site.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

import com.wf.site.models.User;
import com.wf.site.repositories.UserRepository;
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

    @Autowired
    UserRepository userRepository;

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String authenticate(@RequestParam String username, @RequestParam String password, Model model) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            if (user.getRole().equals("admin")) {
                return "admin";
        } else {
            return "loginSucces";
        }
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }

    @ModelAttribute(name = "user")
    public User user() {
        return new User();
    }
}

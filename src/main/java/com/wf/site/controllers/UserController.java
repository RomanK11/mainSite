package com.wf.site.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

import com.wf.site.models.User;
import com.wf.site.repositories.UserRepository;

@Controller
public class UserController {
     private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(path = "/registration")
    public String getQuestionForm() {
        return "registration";
    }

    public boolean existsByField(String fieldValue1, String fieldValue2) {
        return userRepository.findByNameAndPassword(fieldValue1, fieldValue2) != null;
    }

    @PostMapping(path = "/registration")
    public String handleRegistrationForm(@ModelAttribute("user") User user) {
        try {
            if (existsByField(user.getUsername(), user.getPassword()) == false) {
                userRepository.save(user);
            }
        } catch (InternalServerError ex) {
            System.out.println("ex");
        }
        return "registration-succes";
    }

    @ModelAttribute(name = "user")
    public User user() {
        return new User();
    }
}

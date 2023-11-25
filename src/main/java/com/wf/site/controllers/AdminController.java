package com.wf.site.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wf.site.models.User;
import com.wf.site.repositories.UserRepository;

import ch.qos.logback.core.model.Model;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    UserRepository userRepository;

    @GetMapping()
    public String getAdmin(Model model, @ModelAttribute User user) {
        if(user.getUsername() == "admin") {
            return "admin";
        }
        return "index";
    }

    @ModelAttribute(name = "user")
    public User user() {
        return new User();
    }
}

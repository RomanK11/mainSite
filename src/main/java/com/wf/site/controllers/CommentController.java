package com.wf.site.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.wf.site.models.Comment;
import com.wf.site.repositories.CommentRepository;



@Controller
public class CommentController {
    @Autowired
    CommentRepository commentRepository;

    @GetMapping("/comments")
    public String getComments(Model model) {
        Iterable<Comment> comments = commentRepository.findAll();
        model.addAttribute("comments", comments);
        return "comments";
    }
}

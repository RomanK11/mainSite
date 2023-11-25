package com.wf.site.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {
    // @Autowired
    // private Service previewService;
    
    // @GetMapping("/search")
    // public String getVideo() {
    //     return "search";
    // }

    // @PostMapping("/search")
    // public String searchBooks(@RequestParam("title") String title, Model model) {
    //     Iterable<FilmPreview> books = previewService.searchFilms(title);
    //     model.addAttribute("books", books);
    //     return "search-results";
    // }
}

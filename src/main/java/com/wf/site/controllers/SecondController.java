package com.wf.site.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wf.site.models.Second;
import com.wf.site.models.Soap;
import com.wf.site.repositories.SecondRepository;
import com.wf.site.repositories.SoapRepository;

@Controller
@RequestMapping("/menu")
public class SecondController {
    @Autowired
    SecondRepository secondRepository;

    @GetMapping("/seconds")
        public String getMenu(Model model) {
            Iterable<Second> seconds = secondRepository.findAll();
            model.addAttribute("seconds", seconds);
            return "seconds";
    }

    @GetMapping("/addSecond")
    public String getSecondAddPage() {
        return "addSecond";
    }

    @PostMapping("/addSecond")
    public String saveSecond(@ModelAttribute("second") Second second) {
        secondRepository.save(second);
        return "redirect:/menu/seconds";
    }

    @GetMapping(path = "/delete-second/{id}")
    public String getDeleteSecond(@PathVariable("id") Long id, Model model) {
         Iterable<Second> seconds = secondRepository.findAll();
        model.addAttribute("seconds", seconds);
        return "delete-second";
    }
    @PostMapping(path = "/delete-second/{id}")
    public String deleteSecond(@PathVariable("id") Long id) {
        secondRepository.deleteById(id);
        return "redirect:/menu/seconds";
    }

    @ModelAttribute(name = "second")
    public Second second() {
        return new Second();
    }
}

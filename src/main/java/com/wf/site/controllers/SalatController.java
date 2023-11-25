package com.wf.site.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wf.site.models.Salat;
import com.wf.site.models.Second;
import com.wf.site.repositories.SalatRepository;
import com.wf.site.repositories.SecondRepository;

@Controller
@RequestMapping("/menu")
public class SalatController {
    @Autowired
    SalatRepository salatRepository;

    @GetMapping("/salats")
        public String getMenu(Model model) {
            Iterable<Salat> salats = salatRepository.findAll();
            model.addAttribute("salats", salats);
            return "salats";
    }

    @GetMapping("/addSalat")
    public String getSalatAddPage() {
        return "addSalat";
    }

    @PostMapping("/addSalat")
    public String saveSalat(@ModelAttribute("salat") Salat salat) {
        salatRepository.save(salat);
        return "redirect:/menu/salats";
    }

    @GetMapping(path = "/delete-salat/{id}")
    public String getDeleteSalat(@PathVariable("id") Long id, Model model) {
        Iterable<Salat> salats = salatRepository.findAll();
        model.addAttribute("salats", salats);
        return "delete-salat";
    }
    @PostMapping(path = "/delete-salat/{id}")
    public String deleteSalat(@PathVariable("id") Long id) {
        salatRepository.deleteById(id);
        return "redirect:/menu/salats";
    }

    @ModelAttribute(name = "salat")
    public Salat salat() {
        return new Salat();
    }
}

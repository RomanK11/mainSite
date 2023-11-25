package com.wf.site.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wf.site.models.Baker;
import com.wf.site.models.Salat;
import com.wf.site.repositories.BakerRepository;
import com.wf.site.repositories.SalatRepository;

@Controller
@RequestMapping("/menu")
public class BakerController {
    @Autowired
    BakerRepository bakerRepository;

    @GetMapping("/bakers")
        public String getMenu(Model model) {
            Iterable<Baker> bakers = bakerRepository.findAll();
            model.addAttribute("bakers", bakers);
            return "bakers";
    }

    @GetMapping("/addBaker")
    public String getBakerAddPage() {
        return "addBaker";
    }

    @PostMapping("/addBaker")
    public String saveBaker(@ModelAttribute("salat") Baker baker) {
        bakerRepository.save(baker);
        return "redirect:/menu/bakers";
    }

    @GetMapping(path = "/delete-baker/{id}")
    public String getDeleteSalat(@PathVariable("id") Long id, Model model) {
        Iterable<Baker> bakers = bakerRepository.findAll();
        model.addAttribute("bakers", bakers);
        return "delete-baker";
    }
    @PostMapping(path = "/delete-baker/{id}")
    public String deleteBaker(@PathVariable("id") Long id) {
        bakerRepository.deleteById(id);
        return "redirect:/menu/bakers";
    }

    @ModelAttribute(name = "baker")
    public Baker baker() {
        return new Baker();
    }
}

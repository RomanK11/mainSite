package com.wf.site.controllers;

import org.apache.tomcat.jni.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.wf.site.models.Soap;
import com.wf.site.repositories.SoapRepository;

import org.springframework.ui.Model;


@Controller
@RequestMapping("/menu")
public class SoapController {
    @Autowired
    SoapRepository soapRepository;

    @GetMapping("/soaps")
        public String getMenu(Model model) {
            Iterable<Soap> soaps = soapRepository.findAll();
            model.addAttribute("soaps", soaps);
            return "soaps";
    }

    @GetMapping("/addSoap")
    public String getAddPage() {
        return "addSoap";
    }

    @PostMapping("/addSoap")
    public String saveSoap(@ModelAttribute("film") Soap soap) {
        soapRepository.save(soap);
        return "addSoap";
    }

    @GetMapping(path = "/delete-soap/{id}")
    public String getDeleteSoap(@PathVariable("id") Long id, Model model) {
         Iterable<Soap> soaps = soapRepository.findAll();
        model.addAttribute("soaps", soaps);
        return "delete-soap";
    }
    @PostMapping(path = "/delete-soap/{id}")
    public String deleteSoap(@PathVariable("id") Long id) {
        soapRepository.deleteById(id);
        return "home";
    }

    @ModelAttribute(name = "soap")
    public Soap soap() {
        return new Soap();
    }
}

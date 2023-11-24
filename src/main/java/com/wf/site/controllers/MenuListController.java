package com.wf.site.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuListController {
    @GetMapping("/menu-list") 
    public String getMenuList() {
        return "menu-list";
    }
}

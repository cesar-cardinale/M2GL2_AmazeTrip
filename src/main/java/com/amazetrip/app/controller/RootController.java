package com.amazetrip.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RootController {
    /*
     * Point d'entrée principal de l'application.
     */
    @RequestMapping("/")
    public String index() {
        return "redirect:/trips";
    }

}

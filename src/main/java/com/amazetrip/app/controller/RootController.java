package com.amazetrip.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController
{
    @GetMapping("/")
    private String redirectToHomePage(){
        return "redirect:app/trips";
    }
    private String redirectToPlacePage(){return  "redirect:app/places";}
}

package com.jsfsi.javasampleapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

    @GetMapping("/")
    public String redirectToGreetings() {
        return "redirect:/greetings";
    }
}

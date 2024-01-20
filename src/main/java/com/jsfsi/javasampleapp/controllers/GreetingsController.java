package com.jsfsi.javasampleapp.controllers;

import com.jsfsi.javasampleapp.services.GreetingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greetings")
public class GreetingsController {

    private final GreetingsService greetingsService;

    @Autowired
    public GreetingsController(GreetingsService greetingsService) {
        this.greetingsService = greetingsService;
    }

    @GetMapping()
    public ResponseEntity<String> getGreetings() {
        return new ResponseEntity<>("You must specify the greeting name in the path form (ie: /greetings/hello)", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{name}")
    public String getGreetingsByName(@PathVariable String name) {
        return greetingsService.fetchGreeting(name);
    }
}
package com.jsfsi.javasampleapp.services;

import com.jsfsi.javasampleapp.repositories.GreetingsRepository;
import com.jsfsi.javasampleapp.repositories.models.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GreetingsService {

    private final GreetingsRepository greetingsRepository;

    @Autowired
    public GreetingsService(GreetingsRepository greetingsRepository) {
        this.greetingsRepository = greetingsRepository;
    }

    public String fetchGreeting(String name) {
        Optional<Greeting> greeting = this.greetingsRepository.findByname(name);

        if (greeting.isEmpty()) {
            String content = String.format("%s is greeting you!!!", name);

            Greeting newGreeting = new Greeting.Builder().name(name).content(content).build();

            this.greetingsRepository.save(newGreeting);

            return content;
        }

        return greeting.get().getContent();
    }
}

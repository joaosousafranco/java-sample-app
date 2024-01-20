package com.jsfsi.javasampleapp.repositories;

import com.jsfsi.javasampleapp.repositories.models.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GreetingsRepository extends JpaRepository<Greeting, Long> {
    Optional<Greeting> findByname(String name);
}

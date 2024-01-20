package com.jsfsi.javasampleapp.repositories.models;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Greeting {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(unique = true)
    private String name;
    private String content;

    public Greeting() {
    }

    private Greeting(Builder builder) {
        this.name = builder.name;
        this.content = builder.content;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public static class Builder {
        private String name;
        private String content;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder content(String sender) {
            this.content = sender;
            return this;
        }

        public Greeting build() {
            return new Greeting(this);
        }
    }
}

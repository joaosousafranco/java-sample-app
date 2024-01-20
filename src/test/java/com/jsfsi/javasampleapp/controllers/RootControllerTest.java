package com.jsfsi.javasampleapp.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RootController.class)
public class RootControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldRedirectToGreetings() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().is3xxRedirection());

    }
}

package com.jsfsi.javasampleapp.controllers;

import com.jsfsi.javasampleapp.services.GreetingsService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(GreetingsController.class)
public class GreetingsControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GreetingsService greetingsServiceMock;

    @Nested
    @DisplayName("/greetings Get greetings endpoint")
    class GetGreetingsEndpoint {
        @Test
        public void shouldReturnNotFoundGreeting() throws Exception {
            mockMvc.perform(get("/greetings"))
                    .andExpect(status().isNotFound())
                    .andExpect(content().string("You must specify the greeting name in the path form (ie: /greetings/hello)"));

        }
    }

    @Nested
    @DisplayName("/greetings/{name} Get greetings by name endpoint")
    class GetGreetingsByNameEndpoint {
        @Test
        public void shouldReturnGreetingByName() throws Exception {
            when(greetingsServiceMock.fetchGreeting("test")).thenReturn("Im a greetings test");

            mockMvc.perform(get("/greetings/test"))
                    .andExpect(status().isOk())
                    .andExpect(content().string("Im a greetings test"));

        }
    }


}

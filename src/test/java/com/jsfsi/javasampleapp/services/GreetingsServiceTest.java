package com.jsfsi.javasampleapp.services;

import com.jsfsi.javasampleapp.repositories.GreetingsRepository;
import com.jsfsi.javasampleapp.repositories.models.Greeting;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GreetingsServiceTest {

    @Mock
    private GreetingsRepository greetingsRepositoryMock;

    @InjectMocks
    private GreetingsService greetingsService;

    @Test
    public void shouldFetchExistingGreeting() throws Exception {
        when(greetingsRepositoryMock.findByname("test"))
                .thenReturn(
                        Optional.of(
                                new Greeting.Builder().name("test").content("Test is greeting you").build()
                        )
                );

        String greetingText = greetingsService.fetchGreeting("test");

        Assertions.assertEquals(greetingText, "Test is greeting you");

        verify(greetingsRepositoryMock, times(1)).findByname("test");
        verify(greetingsRepositoryMock, times(0)).save(any());
    }

    @Test
    public void shouldFetchNewGreeting() throws Exception {
        when(greetingsRepositoryMock.findByname("test")).thenReturn(Optional.empty());

        String greetingText = greetingsService.fetchGreeting("test");

        Assertions.assertEquals(greetingText, "test is greeting you!!!");

        verify(greetingsRepositoryMock, times(1)).findByname("test");
        verify(greetingsRepositoryMock, times(1)).save(ArgumentMatchers.argThat(
                entity -> entity.getName().equals("test") && entity.getContent().equals("test is greeting you!!!")
        ));
    }
}

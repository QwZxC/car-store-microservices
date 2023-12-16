package com.example.authservice.repository.impl;

import com.example.authservice.repository.UserRepository;
import com.example.userservice.domain.entity.User;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Component
public class UserRepositoryImpl implements UserRepository {

    private final WebClient client;

    public UserRepositoryImpl(WebClient.Builder builder) {
        client = builder.baseUrl("http://localhost:8090/api/v1/users").build();
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return Optional.of(client.get().uri(username).accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(User.class)
                .block());
    }
}

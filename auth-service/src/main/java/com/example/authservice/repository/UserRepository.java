package com.example.authservice.repository;

import com.example.userservice.domain.entity.User;

import java.util.Optional;

public interface UserRepository {

    Optional<User> findByUsername(String username);
}

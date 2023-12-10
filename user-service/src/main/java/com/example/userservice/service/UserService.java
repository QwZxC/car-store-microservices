package com.example.userservice.service;

import com.example.userservice.domain.entity.User;

import java.util.UUID;

public interface UserService {

    User getByUuid(UUID uuid);

    User getByUsername(String username);

    User update(User user);

    User create(User user);

    void deleteByUuid(UUID uuid);
}

package com.example.userservice.service;

import com.example.userservice.domain.entity.User;
import com.example.userservice.web.dto.UserDto;

import java.util.UUID;

public interface UserService {

    User getByUuid(UUID uuid);

    User getByUsername(String username);

    User update(User user);

    void create(UserDto user);

    void deleteByUuid(UUID uuid);
}

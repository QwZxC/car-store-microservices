package com.example.authservice.service;

import com.example.userservice.domain.entity.User;
import com.example.userservice.web.dto.UserDto;

import java.util.UUID;

public interface UserService {

    User findUserByUsername(String username);

    void CreateUser(UserDto dto);
}

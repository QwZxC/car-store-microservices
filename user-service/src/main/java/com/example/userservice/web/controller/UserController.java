package com.example.userservice.web.controller;

import com.example.userservice.service.UserService;
import com.example.userservice.web.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper mapper;
    @GetMapping("/{username}")
    public ResponseEntity<UserDto> getByUsername(@PathVariable String username) {
        return ResponseEntity.ok(
                mapper.map(userService.getByUsername(username), UserDto.class));
    }
}

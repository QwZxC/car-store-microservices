package com.example.userservice.web.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class UserDto {

    private UUID uuid;
    private String name;
    private String username;
    private String password;
    private Long balance = 0L;
    private LocalDateTime registrationDate;
}

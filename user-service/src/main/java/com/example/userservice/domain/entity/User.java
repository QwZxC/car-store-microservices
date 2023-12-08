package com.example.userservice.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
public class User {

    @Id
    @Column(name = "uuid", nullable = false)
    private UUID uuid;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "balance", nullable = false)
    private Long balance = 0L;
    @CreatedDate
    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime registrationDate;
}

package com.example.authservice.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "uuid", nullable = false)
    private UUID uuid;
    @Column(name = "name", unique = true)
    @Enumerated(EnumType.STRING)
    private RoleType name;

}

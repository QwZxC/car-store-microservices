package com.example.authservice.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@IdClass(UserRoleId.class)
public class UserRole {

    @Id
    private UUID userUuid;

    @ManyToOne(optional = false)
    @JoinColumn(name = "role_uuid", nullable = false,insertable = false, updatable = false)
    @JsonBackReference
    private Role role;
    @Id
    @Column(name = "role_uuid")
    private UUID roleUuid;

}

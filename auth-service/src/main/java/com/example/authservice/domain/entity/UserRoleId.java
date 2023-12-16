package com.example.authservice.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRoleId implements Serializable {
    private UUID userUuid;
    private UUID roleUuid;
}

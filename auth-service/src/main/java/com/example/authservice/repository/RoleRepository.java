package com.example.authservice.repository;

import com.example.authservice.domain.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;
import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {

    @Query(value = """
                   SELECT Role
                   FROM UserRole
                   JOIN Role
                    ON UserRole.roleUuid = Role.uuid
                   WHERE UserRole.userUuid = :userUuid
                   """)
    Set<Role> findRolesByUserUuid(@Param("userUuid") UUID userUuid);
}

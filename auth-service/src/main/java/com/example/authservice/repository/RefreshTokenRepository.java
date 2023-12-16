package com.example.authservice.repository;

import com.example.authservice.domain.entity.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, UUID> {

    Optional<RefreshToken> findRefreshTokenByRefreshToken(String refreshToken);

    void deleteRefreshTokenByRefreshToken(String refreshToken);
}

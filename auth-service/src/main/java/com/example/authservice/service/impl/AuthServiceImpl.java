package com.example.authservice.service.impl;

import com.example.authservice.domain.entity.RefreshToken;
import com.example.authservice.domain.exception.types.FailedRefreshException;
import com.example.authservice.repository.RefreshTokenRepository;
import com.example.authservice.service.AuthService;
import com.example.authservice.service.JwtService;
import com.example.authservice.web.dto.auth.AuthRequest;
import com.example.authservice.web.dto.auth.AuthResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtService jwtService;


    @Override
    @Transactional
    public AuthResponse login(AuthRequest loginRequest) {

    }

    @Override
    public AuthResponse refresh(String refreshToken) {

        if (refreshToken == null || !jwtService.isTokenValid(refreshToken)) {
            throw new FailedRefreshException();
        }
        RefreshToken refreshTokenFromDb = refreshTokenRepository
                .findRefreshTokenByRefreshToken(refreshToken)
                .orElseThrow(FailedRefreshException::new);

        );

        return null;
    }
}

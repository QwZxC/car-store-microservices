package com.example.authservice.service;

import com.example.authservice.web.dto.auth.AuthRequest;
import com.example.authservice.web.dto.auth.AuthResponse;

public interface AuthService {

    AuthResponse login(AuthRequest loginRequest);

    AuthResponse refresh(String refreshToken);
}

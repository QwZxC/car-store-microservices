package com.example.userservice.config.security;

import com.example.userservice.domain.entity.User;
import com.example.userservice.service.JwtService;
import com.example.userservice.service.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class JwtTokenFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserService personService;

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain
    ) throws ServletException, IOException {
        Optional<String> accessTokenOptional = getToken(request);
        final String accessToken;
        if (accessTokenOptional.isPresent())
            accessToken = accessTokenOptional.get().substring(7);
        else {
            filterChain.doFilter(request, response);
            return;
        }

        final String userId = jwtService.extractId(accessToken);
        if (userId != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            User user = personService.getByUuid(UUID.fromString(userId));
            if (jwtService.isTokenValid(accessToken)) {
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        user,
                        accessToken,
                        List.of(new SimpleGrantedAuthority(jwtService.extractRole(accessToken)))
                );
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        filterChain.doFilter(request, response);
    }

    private Optional<String> getToken(HttpServletRequest request) {
        return Optional.ofNullable(request.getHeader(HttpHeaders.AUTHORIZATION));
    }
}

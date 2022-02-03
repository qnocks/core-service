package com.itransition.core.service.impl;

import com.itransition.core.dto.AuthResponse;
import com.itransition.core.service.AuthorizationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AuthorizationServiceImpl implements AuthorizationService {

    @Override
    public AuthResponse authorize() {
        AuthResponse authResponse = AuthResponse.builder()
                .accessToken("token")
                .expiresIn(5400L)
                .refreshExpiresIn(0L)
                .tokenType("Bearer")
                .notBeforePolicy(0)
                .scope("profile email")
                .build();

        log.info("IN authorize - returning: {}", authResponse);
        return authResponse;
    }
}

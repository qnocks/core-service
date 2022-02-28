package com.itransition.core.authorization.service.impl;

import com.itransition.core.authorization.dto.AuthResponse;
import com.itransition.core.authorization.service.AuthorizationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationServiceImpl implements AuthorizationService {

    private final Logger log = LogManager.getLogger(AuthorizationServiceImpl.class);

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

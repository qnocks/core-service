package com.itransition.coreservice.authorization.service.impl;

import com.itransition.coreservice.authorization.dto.AuthResponse;
import com.itransition.coreservice.authorization.service.AuthorizationService;
import com.itransition.coreservice.core.exception.custom.ClientException;
import com.itransition.coreservice.core.probability.ProbabilityService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorizationServiceImpl implements AuthorizationService {

    private final Logger log = LogManager.getLogger(AuthorizationServiceImpl.class);
    private final ProbabilityService probabilityService;

    @Override
    public AuthResponse authorize() {
        return (AuthResponse) probabilityService.getWithProbability(
                () -> {
                    val authResponse = AuthResponse.builder()
                            .accessToken("token")
                            .expiresIn(5400L)
                            .refreshExpiresIn(0L)
                            .tokenType("Bearer")
                            .notBeforePolicy(0)
                            .scope("profile email")
                            .build();

                    log.info("IN authorize - returning: {}", authResponse);
                    return authResponse;
                }, () -> {
                    log.info("IN authorize - ERROR OCCURRED");
                    throw ClientException.builder().build();
                }
        );
    }
}

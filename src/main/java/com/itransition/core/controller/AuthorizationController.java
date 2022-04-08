package com.itransition.core.controller;

import com.itransition.core.dto.AuthResponse;
import com.itransition.core.service.AuthorizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthorizationController {

    private final AuthorizationService authorizationService;

    @PostMapping(value = "/token", params = {"grant_type", "client_secret", "client_id"})
    public AuthResponse authorize() {
        return authorizationService.authorize();
    }
}

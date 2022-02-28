package com.itransition.coreservice.authorization.controller;

import com.itransition.coreservice.authorization.dto.AuthResponse;
import com.itransition.coreservice.authorization.service.AuthorizationService;
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
        // TODO: implement 'smart' mocking response when external payment service is over
        //  meanwhile comment out either success or failed response
        return authorizationService.authorize();
    }
}

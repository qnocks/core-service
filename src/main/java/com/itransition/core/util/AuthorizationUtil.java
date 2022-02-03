package com.itransition.core.util;

import org.springframework.http.HttpHeaders;

public final class AuthorizationUtil {

    public static boolean checkAuthorization(HttpHeaders headers) {
        String token = headers.getFirst(HttpHeaders.AUTHORIZATION);
        return "Bearer token".equals(token);
    }
}

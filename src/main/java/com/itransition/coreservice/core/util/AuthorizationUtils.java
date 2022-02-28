package com.itransition.coreservice.core.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpHeaders;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class AuthorizationUtils {

    public static boolean checkAuthorization(HttpHeaders headers) {
        String token = headers.getFirst(HttpHeaders.AUTHORIZATION);
        return "Bearer token".equals(token);
    }
}

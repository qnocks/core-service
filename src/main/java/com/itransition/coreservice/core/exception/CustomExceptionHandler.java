package com.itransition.coreservice.core.exception;

import com.itransition.coreservice.core.exception.custom.ClientException;
import com.itransition.coreservice.core.exception.custom.ServerException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ClientException.class)
    public ResponseEntity<?> handleClientException() {
        return ResponseEntity.badRequest().build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ServerException.class)
    public ResponseEntity<?> handleServerException() {
        return ResponseEntity.internalServerError().build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handlerUnknownException() {
        return ResponseEntity.internalServerError().build();
    }
}

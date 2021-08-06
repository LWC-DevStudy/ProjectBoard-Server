package com.project.board.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = { ApiRequestException.class })
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException ex){
        ApiException apiException = new ApiException(
                ex.getMessage(),
                //HTTP 400 -> Client Error
                HttpStatus.BAD_REQUEST
        );

        return new ResponseEntity<>(
                apiException,
                //HTTP 400 -> Client Error
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(value = { BadCredentialsException.class })
    public ResponseEntity<Object> handleBadCredentialsException(BadCredentialsException ex){
        ApiException apiException = new ApiException(
                ex.getMessage(),
                //HTTP 400 -> Client Error
                HttpStatus.BAD_REQUEST
        );

        return new ResponseEntity<>(
                apiException,
                //HTTP 400 -> Client Error
                HttpStatus.BAD_REQUEST
        );
    }
}

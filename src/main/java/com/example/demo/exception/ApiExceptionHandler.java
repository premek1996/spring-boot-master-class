package com.example.demo.exception;

import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ApiRequestException.class, FeignException.class})
    public ResponseEntity<Object> handleException(Exception exception) {
        ApiException apiException = ApiException.builder()
                .message(exception.getMessage())
                .throwable(exception)
                .zonedDateTime(ZonedDateTime.now())
                .build();
        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(NotFoundException notFoundException) {
        ApiException apiException = ApiException.builder()
                .message(notFoundException.getMessage())
                .throwable(notFoundException)
                .zonedDateTime(ZonedDateTime.now())
                .build();
        return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);
    }

}

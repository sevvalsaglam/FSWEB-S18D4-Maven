package com.workintech.s18d1.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BurgerException.class)
    private ResponseEntity<BurgerErrorResponse> handleBurgerException(BurgerException exception) {
        log.error("Burger exception occured! Exception details: ", exception);
        BurgerErrorResponse  burgerErrorResponse = new BurgerErrorResponse(exception.getMessage());
        return new ResponseEntity<>(burgerErrorResponse, exception.getHttpStatus());
    }

    @ExceptionHandler(Exception.class)
    private ResponseEntity<BurgerErrorResponse> handleBurgerException(Exception exception) {
        log.error("exception occured! Exception details: ", exception);
        BurgerErrorResponse  burgerErrorResponse = new BurgerErrorResponse(exception.getMessage());
        return new ResponseEntity<>(burgerErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}


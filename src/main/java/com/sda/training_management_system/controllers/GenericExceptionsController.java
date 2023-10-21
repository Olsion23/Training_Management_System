package com.sda.training_management_system.controllers;

import com.sda.training_management_system.exceptions.GenericExceptions;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GenericExceptionsController {
    @ExceptionHandler(GenericExceptions.class)
    public ResponseEntity<String> genericException(GenericExceptions genericExceptions){
        return ResponseEntity.status(genericExceptions.getStatus()).body(genericExceptions.getMessage());
    }
}

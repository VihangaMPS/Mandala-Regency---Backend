package com.example.cabinservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CabinExceptionHandler {

    @ExceptionHandler(CabinNotFoundException.class)
    public ResponseEntity<CabinErrorResponse> handleGuestNotFoundException(CabinNotFoundException exc) {

        // create a StudentErrorResponse
        var errorResponse = new CabinErrorResponse();
        errorResponse.setStatus(404);
        errorResponse.setMessage(exc.getMessage());
        errorResponse.setTimeStamp(System.currentTimeMillis());

        // return ResponseEntity
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    // add another exception handler ... to catch any exception (catch all)
    @ExceptionHandler
    public ResponseEntity<CabinErrorResponse> handleException(Exception exc) {

        // create a StudentErrorResponse
        var errorResponse = new CabinErrorResponse();

        errorResponse.setStatus(400);
        errorResponse.setMessage(exc.getMessage());
        errorResponse.setTimeStamp(System.currentTimeMillis());

        // return ResponseEntity
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}

package com.example.guestservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GuestExceptionHandler {

    @ExceptionHandler(GuestNotFoundException.class)
    public ResponseEntity<GuestErrorResponse> handleGuestNotFoundException(GuestNotFoundException exc) {

        // create a StudentErrorResponse
        var errorResponse = new GuestErrorResponse();
        errorResponse.setStatus(404);
        errorResponse.setMessage(exc.getMessage());
        errorResponse.setTimeStamp(System.currentTimeMillis());

        // return ResponseEntity
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    // add another exception handler ... to catch any exception (catch all)
    @ExceptionHandler
    public ResponseEntity<GuestErrorResponse> handleException(Exception exc) {

        // create a StudentErrorResponse
        var errorResponse = new GuestErrorResponse();

        errorResponse.setStatus(400);
        errorResponse.setMessage(exc.getMessage());
        errorResponse.setTimeStamp(System.currentTimeMillis());

        // return ResponseEntity
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}

package com.example.guestservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GuestErrorResponse {

    private int status;
    private String message;
    private long timeStamp;

}

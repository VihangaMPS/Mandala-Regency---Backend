package com.example.cabinservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CabinErrorResponse {

    private int status;
    private String message;
    private long timeStamp;

}

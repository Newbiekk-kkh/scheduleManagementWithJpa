package com.example.schedulemanagement.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class PasswordMismatchException extends Exception{
    private final HttpStatus httpStatus;

    public PasswordMismatchException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}

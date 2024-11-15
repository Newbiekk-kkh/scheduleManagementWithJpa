package com.example.schedulemanagement.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
// 비밀번호 틀릴때 예외처리 401 UNAUTHORIZED
public class PasswordMismatchException extends Exception{
    private final HttpStatus httpStatus;

    public PasswordMismatchException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}

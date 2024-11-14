package com.example.schedulemanagement.dto;

import lombok.Getter;

@Getter
public class SignUpRequestDto {
    private final String username;
    private final String password;
    private final String email;

    public SignUpRequestDto(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}

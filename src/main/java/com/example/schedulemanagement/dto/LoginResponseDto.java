package com.example.schedulemanagement.dto;

import lombok.Getter;

@Getter
public class LoginResponseDto {
    private final Long id;
    private final String email;


    public LoginResponseDto(Long id, String email) {
        this.id = id;
        this.email = email;
    }
}

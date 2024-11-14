package com.example.schedulemanagement.dto;

import lombok.Getter;

@Getter
public class SignUpResponseDto {
    private final Long id;
    private final String username;
    private final String email;

    public SignUpResponseDto(Long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }
}

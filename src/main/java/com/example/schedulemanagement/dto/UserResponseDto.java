package com.example.schedulemanagement.dto;

import com.example.schedulemanagement.entity.Schedule;
import com.example.schedulemanagement.entity.User;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public class UserResponseDto {
    private final Long id;

    private final String username;

    private final String email;

    public UserResponseDto(Long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    // User 객체를 Dto 형태로 변환
    public static UserResponseDto toDto(User user) {
        return new UserResponseDto(user.getId(), user.getUsername(), user.getEmail());
    }
}

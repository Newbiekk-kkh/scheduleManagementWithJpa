package com.example.schedulemanagement.dto;

import lombok.Getter;

@Getter
public class CreateScheduleRequestDto {
    private final String title;

    private final String contents;

    private final String username;

    public CreateScheduleRequestDto(String title, String contents, String username) {
        this.title = title;
        this.contents = contents;
        this.username = username;
    }
}

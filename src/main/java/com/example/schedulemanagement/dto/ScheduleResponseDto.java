package com.example.schedulemanagement.dto;

import lombok.Getter;

@Getter
public class ScheduleResponseDto {
    private final Long id;
    private final String title;
    private final String contents;

    public ScheduleResponseDto(Long id, String title, String contents) {
        this.id = id;
        this.title = title;
        this.contents = contents;
    }
}

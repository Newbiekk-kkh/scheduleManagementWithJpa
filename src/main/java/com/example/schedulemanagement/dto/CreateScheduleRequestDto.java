package com.example.schedulemanagement.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class CreateScheduleRequestDto {
    @NotNull
    @Size(min = 1, max = 10)
    private final String title;

    @NotNull
    private final String contents;

    @NotNull
    private final String username;

    public CreateScheduleRequestDto(String title, String contents, String username) {
        this.title = title;
        this.contents = contents;
        this.username = username;
    }
}

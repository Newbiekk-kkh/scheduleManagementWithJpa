package com.example.schedulemanagement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import org.hibernate.validator.constraints.Range;

@Getter
public class CreateScheduleRequestDto {
    @NotBlank
    @Size(min = 1, max = 10, message = "제목은 1자 이상 10자 이하여야 합니다.")
    private final String title;

    @NotNull
    private final String contents;

    @NotBlank
    @Size(min = 1, max = 4, message = "사용자명은 1자 이상 4자 이하여야 합니다.")
    private final String username;

    public CreateScheduleRequestDto(String title, String contents, String username) {
        this.title = title;
        this.contents = contents;
        this.username = username;
    }
}

package com.example.schedulemanagement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import org.hibernate.validator.constraints.Range;

@Getter
public class UpdateScheduleRequestDto {
    @NotBlank
    @Size(min = 1, max = 10, message = "제목은 1자 이상 10자 이하여야 합니다.")
    private final String title;

    @NotBlank
    private final String contents;

    public UpdateScheduleRequestDto(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
}

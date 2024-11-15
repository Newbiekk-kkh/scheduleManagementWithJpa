package com.example.schedulemanagement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class CreateCommentRequestDto {

    private final Long scheduleId;

    @NotBlank
    private final String commentText;

    public CreateCommentRequestDto(Long scheduleId, String commentText) {
        this.scheduleId = scheduleId;
        this.commentText = commentText;
    }
}

package com.example.schedulemanagement.dto;

import lombok.Getter;

@Getter
public class CreateCommentRequestDto {

    private final Long scheduleId;

    private final String commentText;

    public CreateCommentRequestDto(Long scheduleId, String commentText) {
        this.scheduleId = scheduleId;
        this.commentText = commentText;
    }
}

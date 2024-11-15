package com.example.schedulemanagement.dto;

import com.example.schedulemanagement.entity.Comment;
import com.example.schedulemanagement.entity.User;
import lombok.Getter;

@Getter
public class CommentResponseDto {
    private final Long scheduleId;
    private final Long id;
    private final String commentText;

    public CommentResponseDto(Long scheduleId, Long id, String commentText) {
        this.scheduleId = scheduleId;
        this.id = id;
        this.commentText = commentText;
    }

    public static CommentResponseDto toDto(Comment comment) {
        return new CommentResponseDto(comment.getSchedule().getId(), comment.getId(), comment.getCommentText());
    }
}

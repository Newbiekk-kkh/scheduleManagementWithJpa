package com.example.schedulemanagement.dto;

import com.example.schedulemanagement.entity.Comment;
import com.example.schedulemanagement.entity.User;
import lombok.Getter;

@Getter
public class CommentResponseDto {
    private final Long id;
    private final String commentText;

    public CommentResponseDto(Long id, String commentText) {
        this.id = id;
        this.commentText = commentText;
    }

    public static CommentResponseDto toDto(Comment comment) {
        return new CommentResponseDto(comment.getId(), comment.getCommentText());
    }
}

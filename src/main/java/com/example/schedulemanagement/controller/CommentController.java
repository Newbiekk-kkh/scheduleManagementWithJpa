package com.example.schedulemanagement.controller;

import com.example.schedulemanagement.dto.CommentResponseDto;
import com.example.schedulemanagement.dto.CreateCommentRequestDto;
import com.example.schedulemanagement.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<CommentResponseDto> saveComment(@RequestBody CreateCommentRequestDto requestDto) {
        CommentResponseDto commentResponseDto = commentService.saveComment(requestDto.getScheduleId(), requestDto.getCommentText());

        return new ResponseEntity<>(commentResponseDto, HttpStatus.OK);
    }
}

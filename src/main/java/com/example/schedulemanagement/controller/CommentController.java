package com.example.schedulemanagement.controller;

import com.example.schedulemanagement.dto.CommentResponseDto;
import com.example.schedulemanagement.dto.CreateCommentRequestDto;
import com.example.schedulemanagement.dto.UpdateCommentRequestDto;
import com.example.schedulemanagement.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<CommentResponseDto> saveComment(@Valid @RequestBody CreateCommentRequestDto requestDto) {
        CommentResponseDto commentResponseDto = commentService.saveComment(requestDto.getScheduleId(), requestDto.getCommentText());

        return new ResponseEntity<>(commentResponseDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CommentResponseDto>> viewAllComment() {
        List<CommentResponseDto> commentResponseDtosList = commentService.viewAllcomment();

        return new ResponseEntity<>(commentResponseDtosList, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CommentResponseDto> updateComment(@PathVariable Long id, @RequestBody UpdateCommentRequestDto requestDto) {
        CommentResponseDto commentResponseDto = commentService.updateComment(id, requestDto.getCommentText());

        return new ResponseEntity<>(commentResponseDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}

package com.example.schedulemanagement.service;

import com.example.schedulemanagement.dto.CommentResponseDto;
import com.example.schedulemanagement.entity.Comment;
import com.example.schedulemanagement.entity.Schedule;
import com.example.schedulemanagement.entity.User;
import com.example.schedulemanagement.repository.CommentRepository;
import com.example.schedulemanagement.repository.ScheduleRepository;
import com.example.schedulemanagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;

    public CommentResponseDto saveComment(Long scheduleId, String commentText) {
        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(scheduleId);

        Comment comment = new Comment(commentText);
        comment.setSchedule(findSchedule);

        Comment savedComment = commentRepository.save(comment);

        return new CommentResponseDto(savedComment.getId(), savedComment.getCommentText());
    }
}

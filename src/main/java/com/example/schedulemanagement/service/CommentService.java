package com.example.schedulemanagement.service;

import com.example.schedulemanagement.dto.CommentResponseDto;
import com.example.schedulemanagement.dto.UserResponseDto;
import com.example.schedulemanagement.entity.Comment;
import com.example.schedulemanagement.entity.Schedule;
import com.example.schedulemanagement.entity.User;
import com.example.schedulemanagement.repository.CommentRepository;
import com.example.schedulemanagement.repository.ScheduleRepository;
import com.example.schedulemanagement.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;
    private final HttpSession session;

    @Transactional
    // 세이브 comment 로직
    public CommentResponseDto saveComment(Long scheduleId, String commentText) {
        Long userId = getLoginUserId();
        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(scheduleId);
        User findUser = userRepository.findUserByIdOrElseThrow(userId);

        Comment comment = new Comment(commentText);
        comment.setSchedule(findSchedule);
        comment.setUser(findUser);

        Comment savedComment = commentRepository.save(comment);

        return new CommentResponseDto(savedComment.getSchedule().getId(), savedComment.getId(), savedComment.getCommentText());
    }

    public List<CommentResponseDto> viewAllcomment() {
        return commentRepository
                .findAll()
                .stream()
                .map(CommentResponseDto::toDto)
                .toList();
    }

    @Transactional
    public CommentResponseDto updateComment(Long id, String commentText) {
        Comment findComment = commentRepository.findByIdOrElseThrow(id);
        findComment.updateComment(commentText);
        validateUserPermission(findComment);

        return new CommentResponseDto(findComment.getSchedule().getId(), findComment.getId(), findComment.getCommentText());
    }

    @Transactional
    public void deleteComment(Long id) {
        Comment findComment = commentRepository.findByIdOrElseThrow(id);
        validateUserPermission(findComment);
        commentRepository.delete(findComment);
    }

    private Long getLoginUserId() {
        UserResponseDto loginUser = (UserResponseDto) session.getAttribute("loginUser");
        if (loginUser == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "로그인이 필요합니다.");
        }
        return loginUser.getId();
    }

    // 로그인된 아이디와 Comment 작성자가 같을때만 관리 가능
    private void validateUserPermission(Comment comment) {
        Long userId = getLoginUserId();
        if (!comment.getUser().getId().equals(userId)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "자신의 댓글만 관리할 수 있습니다.");
        }
    }
}

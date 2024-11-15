package com.example.schedulemanagement.controller;

import com.example.schedulemanagement.common.Const;
import com.example.schedulemanagement.dto.LoginRequestDto;
import com.example.schedulemanagement.dto.LoginResponseDto;
import com.example.schedulemanagement.dto.UserResponseDto;
import com.example.schedulemanagement.exception.PasswordMismatchException;
import com.example.schedulemanagement.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class SessionUserController {
    private final UserService userService;

    @PostMapping("/login") // 로그인 로직
    public String login(@Valid @RequestBody LoginRequestDto dto, HttpServletRequest request) throws PasswordMismatchException {
        log.info("로그인 요청: email={}", dto.getEmail());
            LoginResponseDto responseDto = userService.login(dto.getEmail(), dto.getPassword());
            Long userId = responseDto.getId();

            HttpSession session = request.getSession();
            UserResponseDto loginUser = userService.findUserById(userId);
            session.setAttribute(Const.LOGIN_USER, loginUser);

            log.info("로그인에 성공했습니다.");
            return "로그인 성공!";
        }


    @PostMapping("/logout") // 로그아웃 로직
    public String logout(@Valid HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        if (session != null) {
            session.invalidate();
        }
        log.info("로그아웃에 성공했습니다.");
        return "로그아웃 성공!";
    }
}

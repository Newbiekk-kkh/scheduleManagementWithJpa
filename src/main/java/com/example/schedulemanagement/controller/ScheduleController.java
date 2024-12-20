package com.example.schedulemanagement.controller;

import com.example.schedulemanagement.dto.CreateScheduleRequestDto;
import com.example.schedulemanagement.dto.ScheduleResponseDto;
import com.example.schedulemanagement.dto.UpdateScheduleRequestDto;
import com.example.schedulemanagement.dto.UserResponseDto;
import com.example.schedulemanagement.service.ScheduleService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.domain.Sort.Direction.DESC;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;
    private final HttpSession session;

    @PostMapping // 일정 작성
    public ResponseEntity<ScheduleResponseDto> saveSchedule(@Valid @RequestBody CreateScheduleRequestDto requestDto) {
        String username = ((UserResponseDto) session.getAttribute("loginUser")).getUsername();
        ScheduleResponseDto scheduleResponseDto =
                scheduleService.saveSchedule(
                        requestDto.getTitle(),
                        requestDto.getContents(),
                        username
                );

        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.CREATED);
    }

    @GetMapping // 일정 페이징 조회
    public ResponseEntity<Page<ScheduleResponseDto>> makeSchedulePage(@Valid @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        Page<ScheduleResponseDto> schedulePage = scheduleService.makeSchedulePage(page, size);

        return new ResponseEntity<> (schedulePage, HttpStatus.OK);
    }

    @GetMapping("/{id}") // 단일 일정 조회
    public ResponseEntity<ScheduleResponseDto> findScheduleById(@Valid @PathVariable Long id) {
        ScheduleResponseDto scheduleResponseDto = scheduleService.findScheduleById(id);

        return new ResponseEntity<> (scheduleResponseDto, HttpStatus.OK);
    }

    @PatchMapping("/{id}") // 일정 수정
    public ResponseEntity<ScheduleResponseDto> updateSchedule(@Valid @PathVariable Long id, @RequestBody UpdateScheduleRequestDto requestDto) {
        ScheduleResponseDto scheduleResponseDto = scheduleService.updateSchedule(id, requestDto.getTitle(), requestDto.getContents());

        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}") // 일정 삭제
    public ResponseEntity<Void> deleteSchedule(@Valid @PathVariable Long id) {
        scheduleService.deleteSchedule(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}

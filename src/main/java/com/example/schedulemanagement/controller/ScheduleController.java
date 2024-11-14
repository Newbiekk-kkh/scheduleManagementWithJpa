package com.example.schedulemanagement.controller;

import com.example.schedulemanagement.dto.CreateScheduleRequestDto;
import com.example.schedulemanagement.dto.ScheduleResponseDto;
import com.example.schedulemanagement.dto.UpdateScheduleRequestDto;
import com.example.schedulemanagement.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<ScheduleResponseDto> saveSchedule(@RequestBody CreateScheduleRequestDto requestDto) {
        ScheduleResponseDto scheduleResponseDto =
                scheduleService.saveSchedule(
                        requestDto.getTitle(),
                        requestDto.getContents(),
                        requestDto.getUsername()
                );

        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> findAllSchedules() {
        List<ScheduleResponseDto> allSchedules = scheduleService.findAllSchedules();

        return new ResponseEntity<> (allSchedules, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> findScheduleById(@PathVariable Long id) {
        ScheduleResponseDto scheduleResponseDto = scheduleService.findScheduleById(id);

        return new ResponseEntity<> (scheduleResponseDto, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> updateSchedule(@PathVariable Long id, @RequestBody UpdateScheduleRequestDto requestDto) {
        ScheduleResponseDto scheduleResponseDto = scheduleService.updateSchedule(id, requestDto.getTitle(), requestDto.getContents());

        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id) {
        scheduleService.deleteSchedule(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}

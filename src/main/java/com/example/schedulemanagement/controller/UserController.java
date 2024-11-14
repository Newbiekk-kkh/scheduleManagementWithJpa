package com.example.schedulemanagement.controller;

import com.example.schedulemanagement.dto.SignUpRequestDto;
import com.example.schedulemanagement.dto.SignUpResponseDto;
import com.example.schedulemanagement.dto.UserResponseDto;
import com.example.schedulemanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<SignUpResponseDto> signUp(@RequestBody SignUpRequestDto requestDto) {
        SignUpResponseDto signUpResponseDto =
                userService.signUp(
                        requestDto.getUsername(),
                        requestDto.getPassword(),
                        requestDto.getEmail()
                );
        return new ResponseEntity<>(signUpResponseDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> findAllUser() {
        List<UserResponseDto> userResponseDtoList = userService.findAllUsers();

        return new ResponseEntity<>(userResponseDtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findUserById(@PathVariable Long id) {
        UserResponseDto userResponseDto = userService.findUserById(id);

        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}

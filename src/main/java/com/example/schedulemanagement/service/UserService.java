package com.example.schedulemanagement.service;

import com.example.schedulemanagement.dto.LoginResponseDto;
import com.example.schedulemanagement.dto.SignUpResponseDto;
import com.example.schedulemanagement.dto.UserResponseDto;
import com.example.schedulemanagement.entity.User;
import com.example.schedulemanagement.exception.PasswordMismatchException;
import com.example.schedulemanagement.repository.UserRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public SignUpResponseDto signUp(String username, String password ,String email) {
        User user = new User(username, password, email);

        User savedUser = userRepository.save(user);

        return new SignUpResponseDto(savedUser.getId(), savedUser.getUsername(), savedUser.getEmail());
    }

    public List<UserResponseDto> findAllUsers() {
        return userRepository
                .findAll()
                .stream()
                .map(UserResponseDto::toDto)
                .toList();
    }

    public UserResponseDto findUserById(Long id) {
        User findUser = userRepository.findUserByIdOrElseThrow(id);

        return new UserResponseDto(findUser.getId(), findUser.getUsername(), findUser.getEmail());
    }

    @Transactional
    public void deleteUser(Long id) {
        User findUser = userRepository.findUserByIdOrElseThrow(id);

        userRepository.delete(findUser);
    }

    @Transactional
    public LoginResponseDto login(@NotBlank String email, @NotNull String password) throws PasswordMismatchException {
        User user = userRepository.findUserByEmailOrElseThrow(email);

        if (!password.equals(user.getPassword())) {
            throw new PasswordMismatchException("비밀번호가 틀립니다.", HttpStatus.UNAUTHORIZED);
        }

        return new LoginResponseDto(user.getId(), user.getEmail());
    }
}

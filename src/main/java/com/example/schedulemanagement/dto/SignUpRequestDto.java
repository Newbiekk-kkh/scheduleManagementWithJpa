package com.example.schedulemanagement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import org.hibernate.validator.constraints.Range;

@Getter
public class SignUpRequestDto {
    @NotBlank
    @Size(min = 1, max = 4, message = "사용자명은 1자 이상 4자 이하여야 합니다.")
    private final String username;

    @NotBlank
    @Size(min = 1, max = 12, message = "비밀번호는 1자 이상 12자 이하여야 합니다.")
    private final String password;

    @NotBlank
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$", message = "이메일 형식에 맞지 않습니다.")
    private final String email;

    public SignUpRequestDto(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}

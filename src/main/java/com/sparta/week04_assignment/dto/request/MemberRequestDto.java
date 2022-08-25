package com.sparta.week04_assignment.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberRequestDto {

    @NotBlank
    @Size(min = 4, max = 12, message = "닉네임은 4~12자 영문 대 소문자, 숫자를 사용하세요.")
    @Pattern(regexp = "[a-zA-Z\\d]*$")
    private String nickname;

    @NotBlank
    @Size(min = 4, max = 32, message = "비밀번호는 4~32자 영문 소문자, 숫자를 사용하세요.")
    @Pattern(regexp = "[a-z\\d]*$")
    private String password;

    @NotBlank
    private String passwordConfirm;
}

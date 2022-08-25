package com.sparta.week04_assignment.controller;

import com.sparta.week04_assignment.dto.request.MemberRequestDto;
import com.sparta.week04_assignment.dto.response.MemberResponseDto;
import com.sparta.week04_assignment.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
public class UserController {

    private final MemberService memberService;

    // 회원 가입
    @PostMapping("/user/signup")
    public MemberResponseDto signup(@RequestBody @Validated MemberRequestDto requestDto) {
        return memberService.registerMember(requestDto);
    }



}

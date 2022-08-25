package com.sparta.week04_assignment.service;

import com.sparta.week04_assignment.dto.request.MemberRequestDto;
import com.sparta.week04_assignment.dto.response.MemberResponseDto;
import com.sparta.week04_assignment.model.Member;
import com.sparta.week04_assignment.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public MemberResponseDto registerMember(MemberRequestDto requestDto) {
        String nickname = requestDto.getNickname();
        String password = requestDto.getPassword();
        // 회원 ID 중복 확인
        Optional<Member> found = memberRepository.findByNickname(nickname);
        if (found.isPresent()) {
            throw new IllegalArgumentException("중복된 사용자 ID 가 존재합니다.");
        }
        if (!password.equals(requestDto.getPasswordConfirm())) {
            throw new IllegalArgumentException("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
        }

        Member member = new Member(nickname, password);
        MemberRepository.save(member);
        MemberResponseDto memberResponseDto = new MemberResponseDto(member);

        return memberResponseDto;
    }
}

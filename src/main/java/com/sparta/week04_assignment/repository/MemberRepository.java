package com.sparta.week04_assignment.repository;

import com.sparta.week04_assignment.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findById(Long id);
    Optional<Member> findByNickname(String nickname);
}

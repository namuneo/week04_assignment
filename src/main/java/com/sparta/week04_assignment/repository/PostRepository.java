package com.sparta.week04_assignment.repository;

import com.sparta.week04_assignment.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// JpaRepository를 상속해 findall, delete, findBuId등등 사용하겠다.
public interface PostRepository extends JpaRepository<Post, Long> { //JpaRepository<클래스, Id 타입>
    List<Post> findAllByOrderByCreatedAtDesc();
//    List<Post> findAllById();
    // findAll By OrderBy ModifiedAt Desc()
    // OrderBy는 정리를 해달라
    // ModifiedAt을 기준으로
    // Desc 내림차순으로 즉 최신으로
    // JpaRepository https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
}



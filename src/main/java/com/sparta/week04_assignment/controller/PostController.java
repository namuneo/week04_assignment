package com.sparta.week04_assignment.controller;

import com.sparta.week04_assignment.model.Post;
import com.sparta.week04_assignment.repository.PostRepository;
import com.sparta.week04_assignment.dto.request.PostRequestDto;
import com.sparta.week04_assignment.dto.response.PostResponseDto;
import com.sparta.week04_assignment.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostController {
    private final PostRepository postRepository; // 생성, 조회, 삭제
    private final PostService postService; // 변경

    // 전체 게시글 조회
    @GetMapping("/api/posts")
    public List<Post> getAllPost() {
        return postRepository.findAllByOrderByCreatedAtDesc();
    }

    // 게시글 조회
    @GetMapping("/api/posts/{id}")
    public PostResponseDto getPost(@PathVariable Long id) {
        return postService.findById(id); // List에서 Optional로 반환 타입을 변경했을 때 findById 메소드의 매개변수 id의 에러가 사라졌다.
    }

    // 게시글 작성
    @PostMapping("/api/posts")
    public Post createMemo(@RequestBody PostRequestDto requestDto) {
        Post post = new Post(requestDto);
        return postRepository.save(post);
    }

    //삭제
    @DeleteMapping("/api/posts/{id}")
    public Long deletePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재하고 있지 않습니다.")
        );

        if (!post.getPassword().equals(requestDto.getPassword())) {
            throw new IllegalArgumentException("일치하지 않습니다.");
        }
        postRepository.deleteById(id);
        return id;
    }

    // 수정
    @PutMapping("/api/posts/{id}")
    public Long updatePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto) { // @RequestBody request 안에 body라는 녀석을 받아 와야 하는 구나
        postService.update(id, requestDto);
        return id;
    }
}

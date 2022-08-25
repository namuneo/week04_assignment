package com.sparta.week04_assignment.dto.response;

import com.sparta.week04_assignment.model.Post;
import com.sparta.week04_assignment.model.Timestamped;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;


@EntityListeners(AuditingEntityListener.class)
@Getter
public class PostResponseDto extends Timestamped {
    private String title;
    private String username;
    private String content;

    @Builder
    public PostResponseDto(Post post) {
        super.createdAt = post.getCreatedAt();
        this.title = post.getTitle();
        this.username = post.getUsername();
        this.content = post.getContent();
    }

}

package com.sparta.week04_assignment.model;

import java.time.LocalDateTime;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@Getter
@EntityListeners({AuditingEntityListener.class})
public abstract class Timestamped {
    @CreatedDate
    protected LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime modifiedAt;
}

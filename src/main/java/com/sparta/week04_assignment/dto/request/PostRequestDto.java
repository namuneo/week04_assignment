package com.sparta.week04_assignment.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PostRequestDto {
    private String username;
    private String title;
    private String content;
    private String password;
}

package com.example.springbootjpa.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ReviewResponse {
    private Long id;
    private String title;
    private String content;
    private String userName;
    private String message;
}

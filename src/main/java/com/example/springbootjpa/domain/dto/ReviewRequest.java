package com.example.springbootjpa.domain.dto;

import com.example.springbootjpa.domain.entity.Hospital;
import com.example.springbootjpa.domain.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewRequest {
    private String title;
    private String content;
    private String userName;
    private Integer hospitalId;
}

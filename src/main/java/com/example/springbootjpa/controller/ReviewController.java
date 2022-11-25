package com.example.springbootjpa.controller;

import com.example.springbootjpa.domain.dto.HospitalResponse;
import com.example.springbootjpa.domain.dto.ReviewResponse;
import com.example.springbootjpa.service.ReviewService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("") // 리뷰 목록
    public ResponseEntity<List<ReviewResponse>> reviewList(Pageable pageable){
        return ResponseEntity.ok().body(reviewService.getReviews(pageable));
    }

    @GetMapping("/{id}") //리뷰 하나
    public ResponseEntity<ReviewResponse> getReview(@PathVariable Long id) { // ResponseEntity도 DTO타입
        ReviewResponse reviewResponse = reviewService.getReview(id); // DTO
        return ResponseEntity.ok().body(reviewResponse); // Return은 DTO로
    }
}

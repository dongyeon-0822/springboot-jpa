package com.example.springbootjpa.service;

import com.example.springbootjpa.domain.dto.HospitalResponse;
import com.example.springbootjpa.domain.dto.ReviewRequest;
import com.example.springbootjpa.domain.dto.ReviewResponse;
import com.example.springbootjpa.domain.entity.Hospital;
import com.example.springbootjpa.domain.entity.Review;
import com.example.springbootjpa.repository.HospitalRepository;
import com.example.springbootjpa.repository.ReviewRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final HospitalRepository hospitalRepository;

    public ReviewService(ReviewRepository reviewRepository, HospitalRepository hospitalRepository) {
        this.reviewRepository = reviewRepository;
        this.hospitalRepository = hospitalRepository;
    }

    // review 요청을 받아 DB에 저장하고 응답을 반환한다.
    public ReviewResponse add(ReviewRequest reviewCreateRequest) {
        // 병원 id를 받아와서
        Optional<Hospital> hospital = hospitalRepository.findById(reviewCreateRequest.getHospitalId());
        //요청에 맞는 entity를 생성
        Review review = Review.builder()
                .title(reviewCreateRequest.getTitle())
                .content(reviewCreateRequest.getContent())
                .userName(reviewCreateRequest.getUserName())
                .hospital(hospital.get())
                .build();
        // DB에 entity 저장
        Review savedReview = reviewRepository.save(review);
        // entity -> reponse로 바꾸어 반환
        return new ReviewResponse(savedReview.getId(), savedReview.getTitle(), savedReview.getContent(), savedReview.getContent(),
                "리뷰 등록이 성공 했습니다.");
    }
    public List<ReviewResponse> getReviews(Pageable pageable){
        Page<Review> reviews = reviewRepository.findAll(pageable);
        List<ReviewResponse> reviewResponses = reviews.stream()
                .map(review -> ReviewResponse.of(review)).collect(Collectors.toList());
        return reviewResponses;
    }
    public ReviewResponse getReview(Long id){
        Optional<Review> optionalReview = reviewRepository.findById(id);
        ReviewResponse reviewResponse=ReviewResponse.of(optionalReview.get());
        return reviewResponse;
    }
}

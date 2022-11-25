package com.example.springbootjpa.repository;

import com.example.springbootjpa.domain.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAllByHospitalId(Integer id);
}

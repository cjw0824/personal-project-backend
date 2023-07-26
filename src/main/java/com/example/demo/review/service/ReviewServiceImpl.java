package com.example.demo.review.service;

import com.example.demo.review.controller.form.ReviewRequestForm;
import com.example.demo.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
@Slf4j
@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{
    final private ReviewRepository reviewRepository;
    @Override
    public void register(ReviewRequestForm reviewRequestForm) {
        reviewRepository.save(reviewRequestForm.toReview());
    }
}

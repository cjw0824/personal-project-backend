package com.example.demo.review.service;

import com.example.demo.board.entity.Board;
import com.example.demo.review.controller.form.ReviewRequestForm;
import com.example.demo.review.entity.Review;

import java.util.List;

public interface ReviewService {
    void register(ReviewRequestForm reviewRequestForm);

    List<Review> list();

    Review readReview(Long id);
}

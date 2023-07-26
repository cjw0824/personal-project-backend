package com.example.demo.review.controller.form;

import com.example.demo.review.entity.Review;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ReviewRequestForm {

    final private String content;
    final private Float starRating1;
    final private Float starRating2;

    public Review toReview() {
        return new Review(content, starRating1, starRating2);
    }
}

package com.example.demo.review.controller.form;

import com.example.demo.review.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewRequestForm {

    private String content;
    private String placeName;
    private String userEmail;
    private Float starRating1;
    private Float starRating2;

    public Review toReview() {
        return new Review(content, placeName, userEmail, starRating1, starRating2);
    }
}

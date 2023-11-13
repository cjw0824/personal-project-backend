package com.example.demo.reviewTest;

import com.example.demo.review.controller.form.ReviewRequestForm;
import com.example.demo.review.entity.Review;
import com.example.demo.review.service.ReviewService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JunitReviewTest {
    @Autowired
    private ReviewService reviewService;

    @Test
    @DisplayName("테스트 리뷰 등록")
    void 테스트_리뷰_등록 () {
        final String content = "content";
        final String placeName = "창동수영장";
        final String userEmail = "test2@test.com";
        final Float starRating1 = 4f;
        final Float starRating2 = 3f;

        ReviewRequestForm reviewRequestForm = new ReviewRequestForm(content, placeName, userEmail, starRating1, starRating2);
        reviewService.register(reviewRequestForm);
    }

    @Test
    @DisplayName("테스트 리뷰 읽기")
    void 테스트_리뷰_읽기 () {
        Review review = reviewService.readReview(1L);
        System.out.println(review);
    }

    @Test
    @DisplayName("수영장 리뷰 삭제")
    void delete_review() {
        long reviewId = 1l;
        String placeName = "창동수영장";
        reviewService.deleteReview(reviewId);

        //삭제 확인
        reviewService.readReview(reviewId);
    }

}

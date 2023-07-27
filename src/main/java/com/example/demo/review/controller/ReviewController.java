package com.example.demo.review.controller;

import com.example.demo.review.controller.form.ReviewRequestForm;
import com.example.demo.review.entity.Review;
import com.example.demo.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewController {
    final private ReviewService reviewService;
    @PostMapping("/register")
    public void register (@RequestBody ReviewRequestForm reviewRequestForm) {
        log.info("registerAccount()");
        reviewService.register(reviewRequestForm);
    }

    @GetMapping("/list")
    public List<Review> reviewList () {
        log.info("reviewList()");

        List<Review> returnedReviewList = reviewService.list();
        log.info("returnedReviewList: " + returnedReviewList);

        return returnedReviewList;
    }
}


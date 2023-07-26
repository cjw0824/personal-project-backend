package com.example.demo.review.controller;

import com.example.demo.review.controller.form.ReviewRequestForm;
import com.example.demo.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}


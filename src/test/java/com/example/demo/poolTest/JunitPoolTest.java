package com.example.demo.poolTest;

import com.example.demo.pool.controller.form.PoolRequestForm;
import com.example.demo.pool.repository.PoolRepository;
import com.example.demo.pool.service.PoolService;
import com.example.demo.review.controller.form.ReviewRequestForm;
import com.example.demo.review.service.ReviewService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JunitPoolTest {
    @Autowired
    private PoolService poolService;
    @Autowired
    private PoolRepository poolRepository;

    @Test
    @DisplayName("수영장 평균 별점 출력")
    void print_star_avg () {
        String placeName = "창동수영장";
        PoolRequestForm poolRequestForm = poolService.starAvg(placeName);
        System.out.println("starAvg1 = " + poolRequestForm.getStarRating1Avg());
        System.out.println("starAvg2 = " + poolRequestForm.getStarRating2Avg());
    }
}

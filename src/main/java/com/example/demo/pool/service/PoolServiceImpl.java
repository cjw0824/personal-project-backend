package com.example.demo.pool.service;

import com.example.demo.pool.controller.form.PoolRequestForm;
import com.example.demo.pool.entity.Pool;
import com.example.demo.pool.repository.PoolRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor

public class PoolServiceImpl implements PoolService{
    final private PoolRepository poolRepository;
    @Override
    public PoolRequestForm starAvg(String placeName) {
        Optional<Pool> maybePool = poolRepository.findByPlaceName(placeName);
        if(maybePool.isPresent()){
            int reviewCnt = maybePool.get().getReviewCnt();
            float starRating1Total = maybePool.get().getStarRating1Total();
            float starRating2Total = maybePool.get().getStarRating2Total();

            float star1Avg = Math.round(starRating1Total/reviewCnt);
            float star2Avg = Math.round(starRating2Total/reviewCnt);

            PoolRequestForm poolRequestForm = new PoolRequestForm(star1Avg, star2Avg);

            return poolRequestForm;
        } else {
            PoolRequestForm poolRequestForm = new PoolRequestForm(0f, 0f);
            return poolRequestForm;
        }
    }
}

package com.example.demo.pool.service;

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
    public float[] starAvg(String placeName) {
        Optional<Pool> maybePool = poolRepository.findByPlaceName(placeName);
        if(maybePool.isPresent()){
            int reviewCnt = maybePool.get().getReviewCnt();
            float starRating1Total = maybePool.get().getStarRating1Total();
            float starRating2Total = maybePool.get().getStarRating2Total();

            float star1Avg = Math.round(starRating1Total/reviewCnt);
            float star2Avg = Math.round(starRating2Total/reviewCnt);

            float[] starAvgArray = {star1Avg, star2Avg};
            return starAvgArray;
        } else {
            float[] starAvgArray = {0, 0};
            return starAvgArray;
        }
    }
}

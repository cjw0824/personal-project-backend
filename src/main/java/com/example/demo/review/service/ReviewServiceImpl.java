package com.example.demo.review.service;

import com.example.demo.pool.entity.Pool;
import com.example.demo.pool.repository.PoolRepository;
import com.example.demo.review.controller.form.ReviewRequestForm;
import com.example.demo.review.entity.Review;
import com.example.demo.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{
    final private ReviewRepository reviewRepository;
    final private PoolRepository poolRepository;
    @Override
    public void register(ReviewRequestForm reviewRequestForm) {
        Optional<Pool> maybePool = poolRepository.findByPlaceName(reviewRequestForm.getPlaceName());
        Pool pool;
        //pool 없으면 생성
        if(maybePool.isEmpty()){
            log.info("maybePool is Empty");
            pool = new Pool(reviewRequestForm.getPlaceName(), 0, 0f, 0f);
        }
        //있으면 가져와서 reviewCnt +1, 평균 별점
        else {
            log.info("maybePool is Present" + maybePool.get().getPlaceName());
            pool = maybePool.get();
        }

        pool.setReviewCnt(pool.getReviewCnt() + 1);

        Float starRating1ByForm = reviewRequestForm.getStarRating1();
        Float starRating2ByForm = reviewRequestForm.getStarRating2();

        pool.setStarRating1Total(pool.getStarRating1Total() + starRating1ByForm);
        pool.setStarRating2Total(pool.getStarRating2Total() + starRating2ByForm);

        reviewRepository.save(reviewRequestForm.toReview());
        poolRepository.save(pool);
    }

    @Override
    public List<Review> list() {
        return reviewRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    @Override
    public Review readReview(Long id) {
        Optional<Review> maybeReview = reviewRepository.findById(id);

        if (maybeReview.isEmpty()) {
            log.info("정보가 없습니다!");
            return null;
        }

        return maybeReview.get();
    }
}

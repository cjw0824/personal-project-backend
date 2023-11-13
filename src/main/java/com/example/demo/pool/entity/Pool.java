package com.example.demo.pool.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Pool {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String placeName;
    private int reviewCnt;
    private Float starRating1Total;
    private Float starRating2Total;

    public Pool(String placeName, int reviewCnt, Float starRating1Total, Float starRating2Total) {
        this.placeName = placeName;
        this.reviewCnt = reviewCnt;
        this.starRating1Total = starRating1Total;
        this.starRating2Total = starRating2Total;
    }
}

package com.example.demo.review.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private Float starRating1;
    private Float starRating2;

    public Review(String content, Float starRating1, Float starRating2){
        this.content = content;
        this.starRating1 = starRating1;
        this.starRating2 = starRating2;
    }
}

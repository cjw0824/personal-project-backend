package com.example.demo.review.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name="id")
    private Long id;
    private String content;
    private String placeName;
    private Float starRating1;
    private Float starRating2;

    public Review(String content, String placeName, Float starRating1, Float starRating2){
        this.content = content;
        this.placeName = placeName;
        this.starRating1 = starRating1;
        this.starRating2 = starRating2;
    }
}

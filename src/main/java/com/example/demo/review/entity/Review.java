package com.example.demo.review.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


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
    private String userEmail;
    private Float starRating1;
    private Float starRating2;

    public Review(String content, String placeName, String userEmail, Float starRating1, Float starRating2){
        this.content = content;
        this.placeName = placeName;
        this.userEmail = userEmail;
        this.starRating1 = starRating1;
        this.starRating2 = starRating2;
    }
}

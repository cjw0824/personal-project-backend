package com.example.demo.bord.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Bord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bordId;

    private String title;
    private String content;

    public Bord(String title, String content) {
        this.title = title;
        this.content = content;
    }

}

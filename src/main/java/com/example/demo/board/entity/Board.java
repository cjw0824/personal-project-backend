package com.example.demo.board.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Entity
@NoArgsConstructor
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;

    @Setter
    private String title;
    @Setter
    private String content;
    private String userEmail;

    public Board(String title, String content, String userEmail) {
        this.title = title;
        this.content = content;
        this.userEmail = userEmail;
    }

}

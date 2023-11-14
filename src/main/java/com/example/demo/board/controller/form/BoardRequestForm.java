package com.example.demo.board.controller.form;

import com.example.demo.board.entity.Board;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BoardRequestForm {
    @Setter
    private String title;
    @Setter
    private String content;
    private String userEmail;

    public Board toBoard() {
        return new Board(title, content, userEmail);
    }
}

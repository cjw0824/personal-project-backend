package com.example.demo.board.controller.form;

import com.example.demo.board.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
//@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class BoardRequestForm {
    private String title;
    private String content;
    private String userEmail;

    public Board toBoard() {
        return new Board(title, content, userEmail);
    }
}

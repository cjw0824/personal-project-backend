package com.example.demo.board.controller.form;

import com.example.demo.board.entity.Board;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BoardRequestForm {
    final private String title;
    final private String content;

    public Board toBoard() {
        return new Board(title, content);
    }
}

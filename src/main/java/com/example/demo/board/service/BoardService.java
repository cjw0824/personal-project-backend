package com.example.demo.board.service;

import com.example.demo.board.controller.form.BoardRequestForm;
import com.example.demo.board.entity.Board;

import java.util.List;

public interface BoardService {
    void register(BoardRequestForm boardRequestForm);

    List<Board> list();

    Board readBoard(Long boardId);

    void deleteBoard(long boardId);

    Board modifyBoard(long boardId, BoardRequestForm boardRequestForm);
}

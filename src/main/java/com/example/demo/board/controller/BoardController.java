package com.example.demo.board.controller;

import com.example.demo.board.controller.form.BoardRequestForm;
import com.example.demo.board.entity.Board;
import com.example.demo.board.service.BoardService;
import com.example.demo.review.entity.Review;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    final private BoardService boardService;

    @PostMapping("/register")
    public void register (@RequestBody BoardRequestForm boardRequestForm) {
        log.info("registerBoard()");
        boardService.register(boardRequestForm);
    }

    @GetMapping("/list")
    public List<Board> boardList () {
        log.info("boardList()");

        List<Board> returnedBoardList = boardService.list();
        log.info("returnedBoardList: " + returnedBoardList);

        return returnedBoardList;
    }

    @GetMapping("/read/{boardId}")
    public Board readBoard (@PathVariable("boardId") Long boardId) {
        log.info("boardRead()");

        return boardService.readBoard(boardId);
    }

    @DeleteMapping("/delete/{boardId}")
    public void deleteBoard (@PathVariable("boardId") Long boardId) {
        log.info("deleteBoard()");
        boardService.deleteBoard(boardId);
    }

    @PutMapping("/modify/{boardId}")
    public Board modifyBoard (@PathVariable("boardId") Long boardId,
                             @RequestBody BoardRequestForm boardRequestForm) {
        log.info("modifyBoard(), " + ", boardRequestForm: " + boardRequestForm + ", boardId: " + boardId);
        return boardService.modifyBoard(boardId, boardRequestForm);
    }
}

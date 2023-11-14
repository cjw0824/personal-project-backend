package com.example.demo.boardTest;

import com.example.demo.board.controller.form.BoardRequestForm;
import com.example.demo.board.entity.Board;
import com.example.demo.board.repository.BoardRepository;
import com.example.demo.board.service.BoardService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class JunitBoardTest {
    @Autowired
    private BoardService boardService;

    @Autowired
    private BoardRepository boardRepository;

    @Test
    @DisplayName("테스트 게시물 등록")
    void 테스트_게시물_등록 () {
        final String title = "title1";
        final String content = "content";
        final String userEmail = "test1@test.com";

        BoardRequestForm boardRequestForm = new BoardRequestForm(title, content, userEmail);
        boardService.register(boardRequestForm);
    }

    @Test
    @DisplayName("테스트 게시물 목록")
    void 테스트_게시물_목록 () {
        List<Board> testListBoard = boardService.list();
        System.out.println(testListBoard);
    }

    @Test
    @DisplayName("테스트 게시물 읽기")
    void 테스트_게시물_읽기 () {
        Board board = boardService.readBoard(1L);
        System.out.println(board);
    }

    @Test
    @DisplayName("테스트 게시물 삭제")
    void 테스트_게시물_삭제() {
        long boardId = 1L;
        boardService.deleteBoard(boardId);
    }

    @Test
    @DisplayName("테스트 게시물 수정")
    void MODIFY_BOARD() {
        long boardId = 8L;
        String content = "내용";
        String title = "제목";
        String userEmail = "test@test.com";
        BoardRequestForm boardRequestForm = new BoardRequestForm(title, content, userEmail);
        boardService.modifyBoard(boardId, boardRequestForm);
    }
}

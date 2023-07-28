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

        BoardRequestForm boardRequestForm = new BoardRequestForm(title, content);
        boardService.register(boardRequestForm);
    }

    @Test
    @DisplayName("테스트 게시물 목록")
    void 테스트_게시물_목록 () {
        List<Board> testListBoard = boardService.list();
        System.out.println(testListBoard);
    }

//    @Test
//    @DisplayName("테스트 회원탈퇴")
//    void 테스트_회원탈퇴 () {
//        final String email = "test1@test.com";
//        final String password = "test";
//        AccountRequestForm accountRequestForm = new AccountRequestForm(email, password);
//
//        accountService.delete(accountRequestForm);
//    }
//
//    @Test
//    @DisplayName("테스트 로그인")
//    void 테스트_로그인 () {
//        final String email = "test2@test.com";
//        final String password = "test";
//        AccountRequestForm accountRequestForm = new AccountRequestForm(email, password);
//
//        accountService.login(accountRequestForm);
//    }
}

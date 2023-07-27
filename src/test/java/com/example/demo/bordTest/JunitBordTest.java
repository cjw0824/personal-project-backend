package com.example.demo.bordTest;

import com.example.demo.account.controller.form.AccountRequestForm;
import com.example.demo.account.repository.AccountRepository;
import com.example.demo.account.service.AccountService;
import com.example.demo.bord.controller.form.BordRequestForm;
import com.example.demo.bord.repository.BordRepository;
import com.example.demo.bord.service.BordService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JunitBordTest {
    @Autowired
    private BordService bordService;

    @Autowired
    private BordRepository bordRepository;

    @Test
    @DisplayName("테스트 게시물 등록")
    void 테스트_게시물_등록 () {
        final String title = "title1";
        final String content = "content";

        BordRequestForm bordRequestForm = new BordRequestForm(title, content);
        bordService.register(bordRequestForm);
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

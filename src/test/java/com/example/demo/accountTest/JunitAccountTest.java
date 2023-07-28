package com.example.demo.accountTest;

import com.example.demo.account.controller.form.AccountRequestForm;
import com.example.demo.account.repository.AccountRepository;
import com.example.demo.account.service.AccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JunitAccountTest {
    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountRepository accountRepository;

    @Test
    @DisplayName("테스트 회원가입")
    void 테스트_회원가입 () {
        final String email = "test1@test.com";
        final String password = "test";

        AccountRequestForm accountRequestForm = new AccountRequestForm(email, password);
        accountService.register(accountRequestForm);

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

    @Test
    @DisplayName("테스트 로그인")
    void 테스트_로그인 () {
        final String email = "test2@test.com";
        final String password = "test";
        AccountRequestForm accountRequestForm = new AccountRequestForm(email, password);

        accountService.login(accountRequestForm);
    }
}

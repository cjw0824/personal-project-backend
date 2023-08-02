package com.example.demo.account.controller;

import com.example.demo.account.controller.form.AccountLoginResponseForm;
import com.example.demo.account.controller.form.AccountRequestForm;
import com.example.demo.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class MemberAccountController {

    final private AccountService accountService;

    @PostMapping("/register")
    public void register (@RequestBody AccountRequestForm accountRequestForm) {
        log.info("registerAccount()");
        accountService.register(accountRequestForm);
    }

    @PostMapping("/login")
    public AccountLoginResponseForm login (@RequestBody AccountRequestForm accountRequestForm) {
        log.info("login()");
        return accountService.login(accountRequestForm);
    }

}

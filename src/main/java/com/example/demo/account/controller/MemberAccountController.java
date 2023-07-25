package com.example.demo.account.controller;

import com.example.demo.account.controller.form.AccountRequestForm;
import com.example.demo.account.entity.MemberAccount;
import com.example.demo.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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

}

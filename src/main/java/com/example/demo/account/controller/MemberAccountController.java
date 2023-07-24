package com.example.demo.account.controller;

import com.example.demo.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberAccountController {

    final private AccountService accountService;
}

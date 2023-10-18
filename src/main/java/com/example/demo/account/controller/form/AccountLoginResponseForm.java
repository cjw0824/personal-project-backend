package com.example.demo.account.controller.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Getter
@RequiredArgsConstructor
public class AccountLoginResponseForm {
    final private UUID userToken;
    final private String email;
}

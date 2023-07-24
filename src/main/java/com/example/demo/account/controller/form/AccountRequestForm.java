package com.example.demo.account.controller.form;

import com.example.demo.account.entitiy.MemberAccount;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AccountRequestForm {

    final private String email;
    final private String password;

    public MemberAccount toMemberAccount() {
        return new MemberAccount(email, password);
    }

}

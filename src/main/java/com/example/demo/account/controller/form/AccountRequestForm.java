package com.example.demo.account.controller.form;

import com.example.demo.account.entity.MemberAccount;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AccountRequestForm {

    private String email;
    private String password;

    public MemberAccount toMemberAccount() {
        return new MemberAccount(email, password);
    }

}

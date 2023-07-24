package com.example.demo.account.service;


import com.example.demo.account.controller.form.AccountLoginResponseForm;
import com.example.demo.account.controller.form.AccountRequestForm;
import com.example.demo.account.entitiy.MemberAccount;

public interface AccountService {
    void register(AccountRequestForm accountRequestForm);

    void delete(AccountRequestForm accountRequestForm);

    AccountLoginResponseForm login(AccountRequestForm accountRequestForm);
}


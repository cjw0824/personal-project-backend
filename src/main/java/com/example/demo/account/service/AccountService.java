package com.example.demo.account.service;


import com.example.demo.account.controller.form.AccountRequestForm;
import com.example.demo.account.entitiy.MemberAccount;

public interface AccountService {
    MemberAccount register(AccountRequestForm accountRequestForm);

    void delete(AccountRequestForm accountRequestForm);
}


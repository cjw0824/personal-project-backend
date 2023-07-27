package com.example.demo.bord.controller.form;

import com.example.demo.account.entity.MemberAccount;
import com.example.demo.bord.entity.Bord;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BordRequestForm {
    final private String title;
    final private String content;

    public Bord toBord() {
        return new Bord(title, content);
    }
}

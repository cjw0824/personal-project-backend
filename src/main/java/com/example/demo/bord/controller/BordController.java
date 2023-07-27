package com.example.demo.bord.controller;

import com.example.demo.account.controller.form.AccountRequestForm;
import com.example.demo.bord.controller.form.BordRequestForm;
import com.example.demo.bord.entity.Bord;
import com.example.demo.bord.service.BordService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/bord")
public class BordController {

    final private BordService bordService;

    @PostMapping("/register")
    public void register (@RequestBody BordRequestForm bordRequestForm) {
        log.info("registerBord()");
        bordService.register(bordRequestForm);
    }
}

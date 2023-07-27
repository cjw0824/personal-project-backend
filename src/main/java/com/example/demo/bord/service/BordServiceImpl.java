package com.example.demo.bord.service;

import com.example.demo.bord.controller.form.BordRequestForm;
import com.example.demo.bord.repository.BordRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class BordServiceImpl implements BordService{
    final private BordRepository bordRepository;
    @Override
    public void register(BordRequestForm bordRequestForm) {
        bordRepository.save(bordRequestForm.toBord());
    }
}

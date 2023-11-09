package com.example.demo.pool.controller;

import com.example.demo.pool.controller.form.PoolRequestForm;
import com.example.demo.pool.entity.Pool;
import com.example.demo.pool.service.PoolService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/pool")
public class PoolController {
    final private PoolService poolService;

    @GetMapping("/detail")
    public PoolRequestForm getPooldetail(@RequestParam String placeName) {
        log.info("getPooldetail()");
        return poolService.starAvg(placeName);
    }
}


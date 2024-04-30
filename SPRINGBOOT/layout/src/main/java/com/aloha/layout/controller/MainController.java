package com.aloha.layout.controller;

import org.springframework.stereotype.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Slf4j
@Controller
public class MainController {
    
    @GetMapping("/main")
    public String main() {
        log.info("메인화면...");
        return "main";
    }
    
}

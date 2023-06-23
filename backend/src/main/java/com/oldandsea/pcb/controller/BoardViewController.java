package com.oldandsea.pcb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardViewController {

    @GetMapping("/main")
    public String getBoardListPage() {
        return "board";
    }
}


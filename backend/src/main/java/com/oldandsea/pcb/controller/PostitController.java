package com.oldandsea.pcb.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PostitController {
    @GetMapping ("/postit")
    public String viewPostIt() {
        return "postit";
    }
}

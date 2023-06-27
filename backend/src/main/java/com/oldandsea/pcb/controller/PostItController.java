package com.oldandsea.pcb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostItController {
    @GetMapping ("/postit")
    public String viewPostIt() {
        return "postit";
    }
}

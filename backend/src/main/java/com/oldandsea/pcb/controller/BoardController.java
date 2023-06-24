package com.oldandsea.pcb.controller;

import com.oldandsea.pcb.domain.dto.BoardCreateDto;
import com.oldandsea.pcb.domain.repository.boardrepository.BoardRepository;
import com.oldandsea.pcb.service.BoardCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    public final BoardCreateService boardCreateService;

    @GetMapping()
    public String viewCreateBoard(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session==null) {
            return "redirect:/";
        }
        return "write";
    }
    @PostMapping()
    public String createBoard(@RequestBody BoardCreateDto boardCreateDto) {
       boardCreateService.createBoard(boardCreateDto);
       return "redirect/main";
    }
}

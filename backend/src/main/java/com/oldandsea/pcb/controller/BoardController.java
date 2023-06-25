package com.oldandsea.pcb.controller;

import com.oldandsea.pcb.common.SessionConst;
import com.oldandsea.pcb.domain.dto.BoardCreateDto;
import com.oldandsea.pcb.domain.dto.BoardResponseDto;
import com.oldandsea.pcb.domain.repository.boardrepository.BoardRepository;
import com.oldandsea.pcb.service.BoardCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    public final BoardCreateService boardCreateService;

    @GetMapping("/create")

    public String viewCreateBoard() {
        return "write";
    }
    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<BoardResponseDto> createBoard(@RequestBody BoardCreateDto boardCreateDto, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session!=null) {
            Long memberId = (Long) session.getAttribute(SessionConst.LOGIN_MEMBER);
            if (memberId != null) {
                return ResponseEntity.ok(boardCreateService.createBoard(boardCreateDto, memberId));
            }
            else {
                throw new IllegalArgumentException("로그인을 해주세요!");
            }
        }
        else {
            throw new IllegalArgumentException("맛있는 건 정말 참을 수 없어!");
        }
    }

    @GetMapping("/view")
    public String viewBoard() {
        return "board";
    }
}

package com.oldandsea.pcb.controller;

import com.oldandsea.pcb.common.SessionConst;
import com.oldandsea.pcb.domain.dto.request.BoardCreateRequestDto;
import com.oldandsea.pcb.domain.dto.response.BoardCreateResponseDto;
import com.oldandsea.pcb.service.BoardCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    public final BoardCreateService boardCreateService;

    @PostMapping("/create")
    public ResponseEntity<BoardCreateResponseDto> createBoard(@RequestBody BoardCreateRequestDto boardCreateDto, HttpServletRequest request) {
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
            throw new IllegalArgumentException("로그인을 하랑깨요!");
        }
    }

}

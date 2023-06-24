package com.oldandsea.pcb.controller;

import com.oldandsea.pcb.common.SessionConst;
import com.oldandsea.pcb.domain.dto.MemberDto;

import com.oldandsea.pcb.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RequestMapping("/users")
@Controller
@RequiredArgsConstructor
public class MemberController {

    public final MemberService memberService;
    @GetMapping("/create")
    public String signUpPage() {
        return "signup";
    }

    @PostMapping("/create")
    public ResponseEntity<String> insertMember(@RequestBody MemberDto memberDto) {
        if (memberService.memberCheck(memberDto)) {
            memberService.createMember(memberDto);
            return ResponseEntity.ok("Member created successfully");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Duplicate ID");
        }
    }
    @GetMapping("/login")
        public String loginPage() {
            return "login";
        }
    @PostMapping("/login")
    public String login(@RequestPart MemberDto memberDto, HttpSession session) {
        MemberDto loginResult = memberService.login(memberDto);
        if(loginResult != null) {
            session.setAttribute(SessionConst.LOGIN_MEMBER,loginResult.getMemberId());
        }
        return "redirect:/";
    }
}


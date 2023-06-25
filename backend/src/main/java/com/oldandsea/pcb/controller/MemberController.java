package com.oldandsea.pcb.controller;

import com.oldandsea.pcb.common.SessionConst;
import com.oldandsea.pcb.domain.dto.MemberDto;

import com.oldandsea.pcb.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/create")
    public String signUpPage() {
        return "signup";
    }

    @PostMapping("/create")
    @ResponseBody
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
    @ResponseBody
    public ResponseEntity<String> login(@RequestBody MemberDto memberDto, HttpSession session) {
        MemberDto loginResult = memberService.login(memberDto);
        if(loginResult != null) {
            session.setAttribute(SessionConst.LOGIN_MEMBER,loginResult.getMemberId());
            return ResponseEntity.ok("Login Success");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed");
        }
    }
    @PostMapping("/logout")
    @ResponseBody
    public ResponseEntity<String> logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session!=null) {
            session.invalidate();
            return ResponseEntity.ok(("Logout success"));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Please Login First");
        }
    }
}





package com.oldandsea.pcb.controller;

import com.oldandsea.pcb.domain.dto.MemberDto;

import com.oldandsea.pcb.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RequestMapping("/users")
@Controller
@RequiredArgsConstructor
public class MemberController {

    public final MemberService memberService;
    @GetMapping("/create")
    public String signUpPage() {
        return "signup.html";
    }

    @PostMapping("/create")
    public ResponseEntity<String> insertMember(@RequestPart MemberDto memberDto) {
        if (memberService.memberCheck(memberDto)) {
            memberService.createMember(memberDto);
            return ResponseEntity.ok("Member created successfully");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Duplicate ID");
        }

    }
}


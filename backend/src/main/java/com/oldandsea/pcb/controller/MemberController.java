//package com.oldandsea.pcb.controller;
//
//import com.oldandsea.pcb.domain.entity.Member;
//import com.oldandsea.pcb.domain.repository.MemberRepository;
//import com.oldandsea.pcb.service.MemberService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//@RequestMapping("/users")
//@Controller
//@RequiredArgsConstructor
//public class MemberController {
//    public final MemberRepository memberRepository;
//    @PostMapping()
//    public Member insertMember(
//            @RequestParam(value = "identification", required = true) String identification,
//            @RequestParam(value = "pwd", required = true) String pwd,
//            @RequestParam(value = "nickname", required = true) String nickname) {
//            return MemberService.createMember(identification,pwd,nickname);
//    }
//}

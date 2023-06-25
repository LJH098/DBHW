package com.oldandsea.pcb.controller;

import com.oldandsea.pcb.common.SessionConst;
import com.oldandsea.pcb.domain.entity.Member;
import com.oldandsea.pcb.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class AfterLoginController {
    public final MemberRepository memberRepository;

    @GetMapping("/checklogin")
    @ResponseBody
    public ResponseEntity<String> checkLogin(HttpSession session) {
        // Check if session contains LOGIN_MEMBER attribute
        if (session.getAttribute(SessionConst.LOGIN_MEMBER) != null) {
            // If attribute exists, return HTTP status OK
            return ResponseEntity.ok("Logged In");
        } else {
            // If attribute doesn't exist, return HTTP status UNAUTHORIZED
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Not Logged In");
        }
    }
}

//    public ResponseEntity<String> checkSession(HttpServletRequest request, Model model) {
//        HttpSession session = request.getSession(false);
//        if(session==null) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed");
//        }
//        Long memberId = (Long)session.getAttribute(SessionConst.LOGIN_MEMBER);
//        Optional<Member> findMemberOptional = memberRepository.findByMemberId(memberId);
//        Member member = findMemberOptional.orElse(null);
//        if(member == null) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed");
//        }
//        model.addAttribute("member", member);
//        return ResponseEntity.ok("Login success");
//    }


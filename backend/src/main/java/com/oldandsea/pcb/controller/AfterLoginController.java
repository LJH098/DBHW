package com.oldandsea.pcb.controller;

import com.oldandsea.pcb.common.SessionConst;
import com.oldandsea.pcb.domain.entity.Member;
import com.oldandsea.pcb.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class AfterLoginController {
    public final MemberRepository memberRepository;
    @GetMapping("/")
    public String checkSession(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        if(session==null) {
            return "login";
        }
        Long memberId = (Long)session.getAttribute(SessionConst.LOGIN_MEMBER);
        Optional<Member> findMemberOptional = memberRepository.findByMemberId(memberId);
        Member member = findMemberOptional.orElse(null);
        if(member == null) {
            return "login";
        }
        model.addAttribute("member", member);
        return "main";
    }
}

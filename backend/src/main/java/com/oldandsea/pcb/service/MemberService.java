package com.oldandsea.pcb.service;

import com.oldandsea.pcb.domain.dto.MemberDto;
import com.oldandsea.pcb.domain.entity.Member;
import com.oldandsea.pcb.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.oldandsea.pcb.domain.entity.QMember.member;

@Service
@RequiredArgsConstructor
public class MemberService {
   public final MemberRepository memberRepository;

   public Member createMember(MemberDto memberDto) {
       Member memeber = Member.builder()
               .identification(memberDto.getIdentification())
               .nickname(memberDto.getNickname())
               .pwd(memberDto.getPwd())
               .build();
       return memberRepository.save(memeber);
   }

}

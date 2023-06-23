package com.oldandsea.pcb.service;


import com.oldandsea.pcb.domain.dto.MemberDto;
import com.oldandsea.pcb.domain.entity.Member;
import com.oldandsea.pcb.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;




@Service
@RequiredArgsConstructor
public class MemberService {
   public final MemberRepository memberRepository;

   public boolean memberCheck(MemberDto memberDto) {
       Member findMember = memberRepository.findByIdentification(memberDto.getIdentification());
       if(findMember == null)
           return true;
        else
           return false;

   }
   @Transactional
   public String createMember(MemberDto memberDto)  {

       Member memeber = Member.builder()
               .identification(memberDto.getIdentification())
               .nickname(memberDto.getNickname())
               .pwd(memberDto.getPwd())
               .build();
       Member findMember = memberRepository.findByIdentification(memeber.getIdentification());
       if(findMember == null) {
           memberRepository.save(memeber);
           return memeber.getIdentification();
       } else {
           return null;
       }
   }
}


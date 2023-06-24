package com.oldandsea.pcb.service;


import com.oldandsea.pcb.domain.dto.MemberDto;
import com.oldandsea.pcb.domain.entity.Member;
import com.oldandsea.pcb.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class MemberService {
    public final MemberRepository memberRepository;

    public boolean memberCheck(MemberDto memberDto) {
        Optional<Member> findMember = memberRepository.findByIdentification(memberDto.getIdentification());

        if (findMember.isEmpty())
            return true;
        else
            return false;

    }

    @Transactional
    public String createMember(MemberDto memberDto) {

        Member memeber = memberDto.toEntity();
        Optional<Member> findMember = memberRepository.findByIdentification(memeber.getIdentification());
        if (findMember.isEmpty()) {
            memberRepository.save(memeber);
            return memeber.getIdentification();
        } else {
            return null;
        }
    }

    @Transactional
    public MemberDto login(MemberDto memberDto) {
        Optional<Member> byMemberIdentification = memberRepository.findByIdentification(memberDto.getIdentification());
        if (byMemberIdentification.isPresent()) {
            Member member = byMemberIdentification.get();

            if (member.getPwd().equals(memberDto.getPwd())) {
                return MemberDto.builder()
                        .memberId(member.getMemberId())
                        .identification(member.getIdentification())
                        .pwd(member.getPwd())
                        .nickname(member.getNickname())
                        .build();

            } else {
                return null;
            }
        }else {
            return null;
        }
    }
}




package com.oldandsea.pcb.service;

import com.oldandsea.pcb.domain.dto.BoardCreateDto;
import com.oldandsea.pcb.domain.dto.BoardResponseDto;
import com.oldandsea.pcb.domain.entity.Board;
import com.oldandsea.pcb.domain.entity.Member;
import com.oldandsea.pcb.domain.repository.MemberRepository;
import com.oldandsea.pcb.domain.repository.boardrepository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class BoardCreateService {
    public final BoardRepository boardRepository;
    public final MemberRepository memberRepository;

    @Transactional
    public BoardResponseDto createBoard(BoardCreateDto boardCreateDto, Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("회원이 존재하지 않습니다."));
        Board board = boardCreateDto.toEntity(member);
        Board save = boardRepository.save(board);
        return BoardResponseDto.builder()
                .boardId(save.getBoardId())
                .title(save.getTitle())
                .content(save.getContent())
                .build();
    }
}






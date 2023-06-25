package com.oldandsea.pcb.service;

import com.oldandsea.pcb.domain.dto.BoardCreateDto;
import com.oldandsea.pcb.domain.dto.BoardResponseDto;
import com.oldandsea.pcb.domain.entity.Board;
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
    @Transactional
    public BoardResponseDto createBoard(BoardCreateDto boardCreateDto) {
            Board board = boardCreateDto.toEntity();
            Board save = boardRepository.save(board);
            return BoardResponseDto.builder()
                    .boardId(save.getBoardId())
                    .title(save.getTitle())
                    .content(save.getContent())
                    .build();
        }


//        BoardCreateDto boardCreateCompleteDto = BoardCreateDto.builder()
//                .boardId(board.getBoardId())
//                .title(board.getTitle())
//                .content(board.getContent())
//                .build();
//        return boardCreateCompleteD
    }




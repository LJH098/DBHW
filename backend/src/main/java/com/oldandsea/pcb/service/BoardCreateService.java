package com.oldandsea.pcb.service;

import com.oldandsea.pcb.domain.dto.BoardCreateDto;
import com.oldandsea.pcb.domain.entity.Board;
import com.oldandsea.pcb.domain.repository.boardrepository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class BoardCreateService {
    public final BoardRepository boardRepository;
    @Transactional
    public void createBoard(BoardCreateDto boardCreateDto) {
        Board board = boardCreateDto.toEntity();
        boardRepository.save(board);
    }
}

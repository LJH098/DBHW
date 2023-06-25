package com.oldandsea.pcb.service;

import com.oldandsea.pcb.domain.dto.BoardListDto;
import com.oldandsea.pcb.domain.entity.Board;
import com.oldandsea.pcb.domain.repository.boardrepository.BoardRepositoryCustom;
import com.oldandsea.pcb.domain.repository.boardrepository.BoardRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.time.ZoneOffset;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MainPageListService {

    private final BoardRepositoryCustom boardRepositoryCustom;

    @Transactional
    public Slice<BoardListDto> getAllBoards(Long lastBoardId, int limit) {
        PageRequest pageRequest = PageRequest.of(0, limit, Sort.by(Sort.Direction.DESC, "boardId"));
        Slice<Board> boardsSlice = boardRepositoryCustom.searchAllBySlice(lastBoardId, pageRequest);

        List<BoardListDto> boardListDtos = boardsSlice.getContent().stream()
                .map(board -> {
                    return BoardListDto.builder()
                .boardId(board.getBoardId())
                .title(board.getTitle())
                .content(board.getContent())
                .createdAt(board.getCreatedAt().toEpochSecond(ZoneOffset.UTC))
                .build();
                })
                .collect(Collectors.toList());

        return new SliceImpl<>(boardListDtos, pageRequest, boardsSlice.hasNext());

    }

}

package com.oldandsea.pcb.controller;

import com.oldandsea.pcb.domain.dto.BoardListDto;
import com.oldandsea.pcb.service.MainPageListService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BoardAPIController {

    private final MainPageListService mainPageListService;

    @GetMapping("/api/main")
    public Slice<BoardListDto> getBoardList(
            @RequestParam(value = "lastBoardId", required = false) Long lastBoardId,
            @RequestParam(value = "limit",defaultValue = "10") int size) {
        return mainPageListService.getAllBoards(lastBoardId, size);
    }
}


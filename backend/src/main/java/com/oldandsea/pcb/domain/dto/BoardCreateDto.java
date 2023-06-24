package com.oldandsea.pcb.domain.dto;

import com.oldandsea.pcb.domain.entity.Board;
import com.oldandsea.pcb.domain.entity.BoardTag;
import com.oldandsea.pcb.domain.entity.Tag;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardCreateDto {
    private String title;
    private String content;


    public Board toEntity() {
        return Board.builder()
                .title(title)
                .content(content)
                .build();
    }
//    private List<BoardTag> conversion(List<String> boardTagList){
//        return boardTagList.stream()
//                .map(tag -> BoardTag.builder()
//                        .board()
//                        .tag()
//                        .build())
//                .collect(Collectors.toList());
//                }

    @Builder
    public BoardCreateDto (String title, String content) {
        this.title = title;
        this.content = content;

    }
}



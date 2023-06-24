//package com.oldandsea.pcb.domain.dto;
//
//
//
//import com.oldandsea.pcb.domain.entity.BoardTag;
//
//import com.oldandsea.pcb.domain.entity.Tag;
//import lombok.AccessLevel;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.IntStream;
//
//@Getter
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
//public class BoardTagDto {
//    private Long boarTagId;
//    private Long boardId;
//    private Long tagId;
//    @Builder
//    public BoardTagDto(BoardTag boardTag) {
//        this.boarTagId = boardTag.getBoardTagId();
//        this.boardId = boardTag.getBoard().getBoardId();
//        this.tagId = boardTag.getTag().getTagId();
//    }
//        public List<BoardTag> conversion(List<String> boardTagList, BoardCreateDto board, TagCreateDto tag){
//        return boardTagList.stream()
//                .map() -> BoardTag.builder()
//                        .board(board.toEntity())
//                        .tag(tag.toListEntity())
//                        .build()
//                .collect(Collectors.toList());
//                }
////    public List<BoardTag> conversion(BoardCreateDto boardCreateDto, TagCreateDto tagCreateDto) {
////        return IntStream.range(0, tagCreateDto.toListEntity().size())
////                .mapToObj(i -> BoardTag.builder()
////                        .board(boardCreateDto.toEntity())
////                        .tag()
////                        .build())
////                .collect(Collectors.toList());
////    }
////    public List<Tag> toListEntity(Tag tag) {
////        return IntStream.range(0, tagListString.size())
////                .mapToObj(i -> Tag.builder()
////                        .name(tagListString.get(i))
////                        .build())
////                .collect(Collectors.toList());
////    }
//}

package com.oldandsea.pcb.domain.dto;

import com.oldandsea.pcb.domain.entity.Tag;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TagCreateDto {
    private List<String> tagListString;

    @Builder
    public TagCreateDto(List<String> tagListString) {
        this.tagListString = tagListString;
    }


    public List<Tag> toListEntity(Tag tag) {
       return IntStream.range(0, tagListString.size())
                .mapToObj(i -> Tag.builder()
                        .name(tagListString.get(i))
                        .build())
                .collect(Collectors.toList());
    }
}

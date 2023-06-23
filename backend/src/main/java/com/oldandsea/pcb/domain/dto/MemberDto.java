package com.oldandsea.pcb.domain.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;


@Getter
@NoArgsConstructor
public class MemberDto {
    private Long memberId;

    private String identification;

    private String pwd;

    private String nickname;
    @Builder
    public MemberDto(Long memberId, String identification, String pwd, String nickname) {
        this.memberId = memberId;
        this.identification = identification;
        this.pwd = pwd;
        this.nickname = nickname;
    }

}

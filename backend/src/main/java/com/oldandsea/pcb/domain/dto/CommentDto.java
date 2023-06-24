package com.oldandsea.pcb.domain.dto;

import com.oldandsea.pcb.domain.entity.Comment;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.ZoneOffset;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommentDto {

        private Long commentId;
        private String content;
        private Long parentId;
       // private String replyContent;
        private Long createdAt;
        @Builder
       public CommentDto(Comment comment) {
                this.commentId = comment.getCommentId();
                this.content = comment.getContent();
                this.parentId = comment.getParentId();
                this.createdAt = comment.getCreatedAt().toEpochSecond(ZoneOffset.UTC);
        }
}


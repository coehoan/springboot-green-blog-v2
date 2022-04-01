package site.metacoding.blogv2.web.api.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.metacoding.blogv2.domain.comment.Comment;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommentResponseDto {
    private Comment comment;
    private boolean auth;
}

package site.metacoding.blogv2.web.api.dto.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.metacoding.blogv2.domain.post.Post;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DetailResponseDto {
    private Post post;
    private boolean auth;
}

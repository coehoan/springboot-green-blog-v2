package site.metacoding.blogv2.web.api;

import javax.servlet.http.HttpSession;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.blogv2.domain.post.Post;
import site.metacoding.blogv2.domain.user.User;
import site.metacoding.blogv2.service.PostService;
import site.metacoding.blogv2.web.api.dto.ResponseDto;
import site.metacoding.blogv2.web.api.dto.post.DetailResponseDto;
import site.metacoding.blogv2.web.api.dto.post.WriteDto;

@RequiredArgsConstructor
@RestController
public class PostApiController {

    private final PostService postService;
    private final HttpSession session;

    @DeleteMapping("/s/api/post/{id}")
    public ResponseDto<?> deleteById(@PathVariable Integer id) {
        postService.글삭제(id);
        return new ResponseDto<>(1, "성공", null);
    }

    @GetMapping("/api/post/{id}")
    public ResponseDto<?> detail(@PathVariable Integer id) {
        Post postEntity = postService.상세보기(id);
        User principal = (User) session.getAttribute("principal");
        boolean auth = false;
        if (principal != null) {

            if (principal.getId() == postEntity.getUser().getId()) {
                auth = true;
            }
        }
        DetailResponseDto detailResponseDto = new DetailResponseDto(postEntity, auth); // comment 없음

        return new ResponseDto<>(1, "성공", detailResponseDto); // comment생성 - 메세지 컨버터 작동
    }

    @GetMapping("/api/post")
    public ResponseDto<?> list(Integer page) {
        Page<Post> posts = postService.목록보기(page);
        // 응답하는 DTO를 만들어서 posts를 옮김 (라이브러리사용)
        // json 리턴시 comment까지 getter를 통해 가져옴
        return new ResponseDto<>(1, "성공", posts);
    }

    @PostMapping("/s/post")
    public ResponseDto<?> write(@RequestBody WriteDto writeDto) {

        User principal = (User) session.getAttribute("principal");
        Post post = writeDto.toEntity(principal);

        postService.글쓰기(post);
        return new ResponseDto<>(1, "성공", null);
    }
}

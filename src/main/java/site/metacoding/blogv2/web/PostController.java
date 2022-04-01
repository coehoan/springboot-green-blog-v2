package site.metacoding.blogv2.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.RequiredArgsConstructor;
import site.metacoding.blogv2.domain.comment.Comment;
import site.metacoding.blogv2.domain.post.Post;
import site.metacoding.blogv2.domain.user.User;
import site.metacoding.blogv2.service.PostService;
import site.metacoding.blogv2.web.api.dto.comment.CommentResponseDto;

@RequiredArgsConstructor
@Controller
public class PostController {

    private final PostService postService;
    private final HttpSession session;

    @GetMapping("/s/post/writeForm")
    public String writeForm() {

        return "post/writeForm";
    }

    @GetMapping({ "/", "/post" })
    public String home() {
        return "post/list";
    }

    @GetMapping("/post/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        Post postEntity = postService.상세보기(id);
        User principal = (User) session.getAttribute("principal");

        List<CommentResponseDto> comments = new ArrayList<>();
        for (Comment comment : postEntity.getComments()) {
            CommentResponseDto dto = new CommentResponseDto();
            dto.setComment(comment);
            if (principal != null) {
                if (comment.getUser().getId().equals(principal.getId())) {
                    dto.setAuth(true);
                } else {
                    dto.setAuth(false);
                }
            } else {
                dto.setAuth(false);
            }
            comments.add(dto);
        }
        model.addAttribute("comments", comments);
        model.addAttribute("postId", id);

        return "post/detail";
    }
}

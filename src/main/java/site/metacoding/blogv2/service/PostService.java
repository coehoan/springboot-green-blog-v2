package site.metacoding.blogv2.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.blogv2.domain.post.Post;
import site.metacoding.blogv2.domain.post.PostRepository;

// 웹브라우저 -> 컨트롤러 -> 서비스 -> 레파지토리 -> 영속성컨텍스트 -> 디비

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    public Post 상세보기(Integer id) {
        Optional<Post> postOp = postRepository.findById(id);
        if (postOp.isPresent()) {
            return postOp.get();
        } else {
            throw new RuntimeException("상세보기 실패");
        }

    }

    public Page<Post> 목록보기(Integer page) {
        PageRequest pr = PageRequest.of(page, 3, Sort.by(Direction.DESC, "id"));
        return postRepository.findAll(pr);
    }

    @Transactional
    public void 글쓰기(Post post) {
        postRepository.save(post);
    }

}

package site.metacoding.blogv2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestViewController {

    @GetMapping("test/user/joinForm")
    public String test1() {
        return "user/joinForm";
    }

    @GetMapping("test/user/loginForm")
    public String test2() {
        return "user/loginForm";
    }

    @GetMapping("test/user/updateForm")
    public String test3() {
        return "user/updateForm";
    }

    @GetMapping("test/user/detail")
    public String test4() {
        return "user/detail";
    }

    @GetMapping("test/post/list")
    public String test5() {
        return "post/list";
    }

    @GetMapping("test/post/detail")
    public String test6() {
        return "post/detail";
    }

    @GetMapping("test/post/writeForm")
    public String test7() {
        return "post/writeForm";
    }

    @GetMapping("test/post/updateForm")
    public String test8() {
        return "post/updateForm";
    }
}

package site.metacoding.blogv2.web.api;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.blogv2.domain.user.User;
import site.metacoding.blogv2.service.UserService;
import site.metacoding.blogv2.web.api.dto.ResponseDto;
import site.metacoding.blogv2.web.api.dto.user.JoinDto;
import site.metacoding.blogv2.web.api.dto.user.LoginDto;
import site.metacoding.blogv2.web.api.dto.user.UpdateDto;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;
    private final HttpSession session;

    @PutMapping("/s/api/user/{id}")
    public ResponseDto<?> update(@RequestBody UpdateDto updateDto, @PathVariable Integer id) {
        userService.회원수정(id, updateDto);
        return new ResponseDto<>(1, "성공", null);
    }

    // 앱에서 실행을 위해서
    // 웹서버에서는 사용 X
    @GetMapping("/s/api/user/{id}")
    public ResponseDto<?> userInfo(@PathVariable Integer id) {
        User userEntity = userService.회원정보(id);
        return new ResponseDto<>(1, "성공", userEntity);
    }

    @GetMapping("/logout")
    public ResponseDto<?> logout() {
        session.invalidate();
        return new ResponseDto<>(1, "성공", null);
    }

    @PostMapping("/join")
    public ResponseDto<?> join(@RequestBody JoinDto joinDto) {

        userService.회원가입(joinDto);

        return new ResponseDto<>(1, "회원가입성공", null);
    }

    @PostMapping("/login")
    public ResponseDto<?> login(@RequestBody LoginDto loginDto, HttpServletResponse response) {

        User userEntity = userService.로그인(loginDto);

        if (userEntity == null) {
            return new ResponseDto<>(-1, "로그인실패", null);
        }

        session.setAttribute("principal", userEntity);
        if (loginDto.getRemember().equals("on")) {
            response.addHeader("Set-Cookie", "remember=" + loginDto.getUsername() + ";path=/");
            // response.addHeader("Set-Cookie", "remember=" + loginDto.getUsername() +
            // ";path=/;HttpOnly=true");
        }
        return new ResponseDto<>(1, "로그인성공", null);

    }

}
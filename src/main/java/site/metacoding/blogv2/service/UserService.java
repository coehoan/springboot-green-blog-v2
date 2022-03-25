package site.metacoding.blogv2.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.blogv2.domain.user.User;
import site.metacoding.blogv2.domain.user.UserRepository;
import site.metacoding.blogv2.web.api.dto.user.JoinDto;
import site.metacoding.blogv2.web.api.dto.user.LoginDto;
import site.metacoding.blogv2.web.api.dto.user.UpdateDto;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void 회원수정(Integer id, UpdateDto updateDto) {
        // UPDATE user SET password=?, email=?, addr=? WHERE id=?
        // 영속화(DB row를 영속성 컨텍스트에 옮김)
        Optional<User> userOp = userRepository.findById(id);

        if (userOp.isPresent()) {
            User userEntity = userOp.get();
            userEntity.setPassword(updateDto.getPassword());
            userEntity.setEmail(updateDto.getEmail());
            userEntity.setAddr(updateDto.getAddr());
        } else {
            throw new RuntimeException("아이디를 찾을 수 없습니다");
        }
    } // 트랜잭션이 걸려있으면 @Service 종료시에 변경감지해서 DB에 업데이트

    public User 회원정보(Integer id) {
        Optional<User> userOp = userRepository.findById(id);

        if (userOp.isPresent()) {
            return userOp.get();
        } else {
            throw new RuntimeException("아이디를 찾을 수 없습니다");
        }
    }

    @Transactional
    public void 회원가입(JoinDto joinDto) {
        // save하면 db에 insert하고 insert 결과를 다시 return 해줌
        userRepository.save(joinDto.toEntity());
    }

    public User 로그인(LoginDto loginDto) {
        User userEntity = userRepository.mLogin(loginDto.getUsername(), loginDto.getPassword());
        return userEntity;
    }
}

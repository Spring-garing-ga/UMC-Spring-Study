package umc.study.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.spring.repository.UserRepository;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public void checkUser(Integer userId) throws Exception {

        if(!userRepository.existsById(Long.valueOf(userId))) {
            throw new Exception("존재하지 않는 유저입니다.");
        }

    }

}

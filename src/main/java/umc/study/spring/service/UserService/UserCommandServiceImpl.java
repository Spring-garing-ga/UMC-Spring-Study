package umc.study.spring.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.spring.converter.UserConverter;
import umc.study.spring.domain.User;
import umc.study.spring.repository.UserRepository;
import umc.study.spring.web.dto.UserRequestDTO;



@Service
@RequiredArgsConstructor
public class UserCommandServiceImpl implements UserCommandService {

    private final UserRepository userRepository;

    @Override
    public User joinUser(UserRequestDTO.JoinDto request) {

        User newUser = UserConverter.toUser(request);

        return null;
    }
}
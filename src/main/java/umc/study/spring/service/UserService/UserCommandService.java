package umc.study.spring.service.UserService;

import umc.study.spring.domain.User;
import umc.study.spring.web.dto.UserRequestDTO;

public interface UserCommandService {
    public User joinUser(UserRequestDTO.JoinDto request);
}

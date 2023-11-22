package umc.study.spring.service.userService;

import umc.study.spring.domain.User;
import umc.study.spring.web.dto.UserRequestDTO;


public interface UserCommandService {

    public User joinUser(UserRequestDTO.JoinDTO request);
    public void checkUser(Integer userId) throws Exception;
}

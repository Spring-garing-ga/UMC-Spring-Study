package umc.study.spring.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.spring.repository.UserRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserQueryServiceImpl implements UserQueryService{

    private final UserRepository userRepository;
    @Override
    public boolean isExist(Long id) {
        return userRepository.existsById(id);
    }
}

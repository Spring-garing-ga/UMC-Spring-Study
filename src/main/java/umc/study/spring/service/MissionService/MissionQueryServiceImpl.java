package umc.study.spring.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.spring.domain.User;
import umc.study.spring.domain.mapping.UserMission;
import umc.study.spring.repository.UserMissionRepository;
import umc.study.spring.repository.UserRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements MissionQueryService{
    private final UserRepository userRepository;
    private final UserMissionRepository userMissionRepository;
    @Override
    public Page<UserMission> getUserMissionList(Long userId, Integer page) {
        User user = userRepository.findById(userId).get();
        Page<UserMission> userMissionPage = userMissionRepository.findAllByUser(user, PageRequest.of(page, 10));
        return userMissionPage;
    }
}

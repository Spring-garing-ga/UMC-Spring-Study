package umc.study.spring.service.MissionService;

import org.springframework.data.domain.Page;
import umc.study.spring.domain.mapping.UserMission;

public interface MissionQueryService {
    public Page<UserMission> getUserMissionList(Long userId, Integer page);
}

package umc.study.spring.service.MissionService;

import org.springframework.data.domain.Page;
import umc.study.spring.domain.Mission;
import umc.study.spring.domain.mapping.UserMission;
import umc.study.spring.web.dto.MissionRequestDTO;

public interface MissionCommandService {
    public Mission addMission(MissionRequestDTO.AddMissionDTO request);
}

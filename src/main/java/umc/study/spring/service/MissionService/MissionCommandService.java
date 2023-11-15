package umc.study.spring.service.MissionService;

import org.springframework.stereotype.Service;
import umc.study.spring.domain.Mission;
import umc.study.spring.dto.MissionRequestDTO;

public interface MissionCommandService {
    public Mission addMission(MissionRequestDTO.AddMissionDTO request);
}

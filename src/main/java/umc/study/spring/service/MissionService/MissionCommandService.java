package umc.study.spring.service.MissionService;

import umc.study.spring.domain.Mission;
import umc.study.spring.dto.MissionResponse;
import umc.study.spring.dto.UserMissionRequest;
import umc.study.spring.web.dto.MissionRequestDTO;

public interface MissionCommandService {
    public Mission addMission(MissionRequestDTO.AddMissionDTO request);

    public void checkMission(Integer missionId) throws Exception;

    public MissionResponse.UserMission acceptMission(UserMissionRequest userMissionRequest);

    public MissionResponse.UserMission completeMission(UserMissionRequest userMissionRequest);
}

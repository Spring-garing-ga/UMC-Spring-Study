package umc.study.spring.converter;


import umc.study.spring.domain.Mission;
import umc.study.spring.web.dto.MissionRequestDTO;
import umc.study.spring.web.dto.MissionResponseDTO;

import java.time.LocalDateTime;

public class MissionConverter {
    public static Mission toMission(MissionRequestDTO.AddMissionDTO request){
        return Mission.builder()
                .title(request.getTitle())
                .goal(request.getGoal())
                .point(request.getPoint())
                .description(request.getDescription())
                .deadline(request.getDeadline())
                .build();
    }

    public static MissionResponseDTO.AddMissionResultDTO toAddMissionResultDTO(Mission mission){
        return MissionResponseDTO.AddMissionResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}

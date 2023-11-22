package umc.study.spring.converter;


import umc.study.spring.domain.Mission;
import umc.study.spring.domain.enums.MissionStatus;
import umc.study.spring.domain.mapping.UserMission;
import umc.study.spring.domain.mapping.UserMission;
import umc.study.spring.dto.MissionResponse;
import umc.study.spring.dto.UserMissionRequest;
import umc.study.spring.web.dto.MissionRequestDTO;
import umc.study.spring.web.dto.MissionResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

    public static UserMission toUserMission(UserMissionRequest requestDto) {
        return UserMission.builder()
                .userId(requestDto.getUserId())
                .missionId(requestDto.getMissionId())
                .checkCode(1234)
                .build();
    }

    public static MissionResponse.UserMission toUserMissionResponse(UserMission userMission) {
        return MissionResponse.UserMission.builder()
                .checkCode(userMission.getCheckCode())
                .build();
    }

    public static MissionResponseDTO.MissionDTO toMissionDTO(Mission mission){
        return MissionResponseDTO.MissionDTO.builder()
                .title(mission.getTitle())
                .storeName(mission.getStore().getName())
                .goal(mission.getGoal())
                .point(mission.getPoint())
                .description(mission.getDescription())
                .build();
    }

    public static MissionResponseDTO.MissionListDTO toMissionListDTO (Page<UserMission> userMissionList){
        List<MissionResponseDTO.MissionDTO> missionDTOList = userMissionList.stream()
                .filter(u -> MissionStatus.IN_PROGRESS.equals(u.getStatus()))
                .map(u -> u.getMission())
                .map(MissionConverter::toMissionDTO)
                .collect(Collectors.toList());
        return MissionResponseDTO.MissionListDTO.builder()
                .missionList(missionDTOList)
                .isLast(userMissionList.isLast())
                .isFirst(userMissionList.isFirst())
                .totalPage(userMissionList.getTotalPages())
                .totalElements(userMissionList.getTotalElements())
                .listSize(missionDTOList.size())
                .build();
    }
}

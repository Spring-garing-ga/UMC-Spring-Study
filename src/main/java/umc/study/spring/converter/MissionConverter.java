package umc.study.spring.converter;

import umc.study.spring.domain.mapping.UserMission;
import umc.study.spring.dto.MissionResponse;
import umc.study.spring.dto.UserMissionRequest;

public class MissionConverter {

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
}

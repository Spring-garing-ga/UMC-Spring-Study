package umc.study.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.study.spring.validation.ProgressUserMission;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ProgressUserMission(userId = "userId", missionId = "missionId")
public class UserMissionRequest {

     Integer userId;

     Integer missionId;

}

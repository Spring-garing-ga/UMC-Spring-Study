package umc.study.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.spring.converter.MissionConverter;
import umc.study.spring.domain.mapping.UserMission;
import umc.study.spring.dto.MissionResponse;
import umc.study.spring.dto.UserMissionRequest;
import umc.study.spring.repository.MissionRepository;
import umc.study.spring.repository.UserMissionRepository;

@RequiredArgsConstructor
@Service
public class MissionService {

    public final MissionRepository missionRepository;
    public final UserService userService;
    public final UserMissionRepository userMissionRepository;

    public MissionResponse.UserMission acceptMission(UserMissionRequest userMissionRequest) {

        try{
            userService.checkUser(userMissionRequest.getUserId());
            checkMission(userMissionRequest.getMissionId());
            UserMission savedUer = userMissionRepository.save(MissionConverter.toUserMission(userMissionRequest));
            return MissionConverter.toUserMissionResponse(savedUer);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public void checkMission(Integer missionId) throws Exception {

        if(!missionRepository.existsById(Long.valueOf(missionId))){
            throw new Exception("존재하지 않는 미션입니다.");
        }

    }

}

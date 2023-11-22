package umc.study.spring.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.spring.apiPayload.code.status.ErrorStatus;
import umc.study.spring.apiPayload.exception.handler.StoreHandler;
import umc.study.spring.converter.MissionConverter;
import umc.study.spring.domain.Mission;
import umc.study.spring.domain.Store;
import umc.study.spring.domain.mapping.UserMission;
import umc.study.spring.dto.MissionResponse;
import umc.study.spring.dto.UserMissionRequest;
import umc.study.spring.repository.UserMissionRepository;
import umc.study.spring.service.userService.UserCommandService;
import umc.study.spring.web.dto.MissionRequestDTO;
import umc.study.spring.repository.MissionRepository;
import umc.study.spring.repository.StoreRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionCommandServiceImpl implements MissionCommandService{
    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;

    public final UserCommandService userService;
    public final UserMissionRepository userMissionRepository;
    @Override
    @Transactional
    public Mission addMission(MissionRequestDTO.AddMissionDTO request) {
        Store store = storeRepository.findById(request.getStoreId()).orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));
        Mission newMission = MissionConverter.toMission(request);
        newMission.setStore(store);
        return missionRepository.save(newMission);
    }

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

    @Override
    public MissionResponse.UserMission completeMission(UserMissionRequest userMissionRequest) {
        UserMission userMission = userMissionRepository.findByUserIdAndMissionId(userMissionRequest.getUserId(), userMissionRequest.getMissionId()).orElseThrow(() -> new StoreHandler(ErrorStatus.MISSION_NOT_FOUND));
        userMission.setComplete();
        UserMission savedUserMission = userMissionRepository.save(userMission);
        return MissionConverter.toUserMissionResponse(savedUserMission);
    }

    public void checkMission(Integer missionId) throws Exception {

        if(!missionRepository.existsById(Long.valueOf(missionId))){
            throw new Exception("존재하지 않는 미션입니다.");
        }

    }
}

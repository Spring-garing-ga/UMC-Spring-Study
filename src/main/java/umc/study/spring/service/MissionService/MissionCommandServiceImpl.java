package umc.study.spring.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.spring.apiPayLoad.code.status.ErrorStatus;
import umc.study.spring.apiPayLoad.exception.handler.StoreHandler;
import umc.study.spring.converter.MissionConverter;
import umc.study.spring.domain.Mission;
import umc.study.spring.domain.Store;
import umc.study.spring.domain.User;
import umc.study.spring.domain.mapping.UserMission;
import umc.study.spring.repository.UserMissionRepository;
import umc.study.spring.repository.UserRepository;
import umc.study.spring.web.dto.MissionRequestDTO;
import umc.study.spring.repository.MissionRepository;
import umc.study.spring.repository.StoreRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionCommandServiceImpl implements MissionCommandService{
    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;
    private final UserMissionRepository userMissionRepository;
    private final UserRepository userRepository;
    @Override
    @Transactional
    public Mission addMission(MissionRequestDTO.AddMissionDTO request) {
        Store store = storeRepository.findById(request.getStoreId()).get();
        Mission newMission = MissionConverter.toMission(request);
        newMission.setStore(store);
        return missionRepository.save(newMission);
    }
    //    .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND)

}

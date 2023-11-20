package umc.study.spring.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.spring.apiPayLoad.code.status.ErrorStatus;
import umc.study.spring.apiPayLoad.exception.handler.StoreHandler;
import umc.study.spring.converter.MissionConverter;
import umc.study.spring.domain.Mission;
import umc.study.spring.domain.Store;
import umc.study.spring.web.dto.MissionRequestDTO;
import umc.study.spring.repository.MissionRepository;
import umc.study.spring.repository.StoreRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionCommandServiceImpl implements MissionCommandService{
    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;
    @Override
    @Transactional
    public Mission addMission(MissionRequestDTO.AddMissionDTO request) {
        Store store = storeRepository.findById(request.getStoreId()).orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));
        Mission newMission = MissionConverter.toMission(request);
        newMission.setStore(store);
        return missionRepository.save(newMission);
    }
}

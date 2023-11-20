package umc.study.spring.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.spring.apiPayLoad.ApiResponse;
import umc.study.spring.converter.MissionConverter;
import umc.study.spring.domain.Mission;
import umc.study.spring.web.dto.MissionRequestDTO;
import umc.study.spring.web.dto.MissionResponseDTO;
import umc.study.spring.service.MissionService.MissionCommandService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mission")
@Slf4j
public class MissionRestController {
    private final MissionCommandService missionService;
    @PostMapping("/")
    public ApiResponse<MissionResponseDTO.AddMissionResultDTO> addMission(@RequestBody MissionRequestDTO.AddMissionDTO request){
        log.info("컨트롤러 호출");
        Mission mission = missionService.addMission(request);
        return ApiResponse.onSuccess(MissionConverter.toAddMissionResultDTO(mission));
    }
}

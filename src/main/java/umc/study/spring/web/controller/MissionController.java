package umc.study.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.study.spring.apiPayload.ApiResponse;
import umc.study.spring.dto.MissionResponse;
import umc.study.spring.dto.UserMissionRequest;
import umc.study.spring.service.MissionService.MissionCommandService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mission")
public class MissionController {

    private final MissionCommandService missionService;

    //가게의 미션을 도전 중인 미션에 추가
    @PostMapping("/accept")
    public ApiResponse<MissionResponse.UserMission> acceptMission(@RequestBody @Valid UserMissionRequest userMissionRequest){
        return ApiResponse.onSuccess(missionService.acceptMission(userMissionRequest));
    }

    @PutMapping("/complete")
    public ApiResponse<MissionResponse.UserMission> completeMission(@RequestBody @Valid UserMissionRequest userMissionRequest){
        return ApiResponse.onSuccess(missionService.completeMission(userMissionRequest));
    }

}

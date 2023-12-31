package umc.study.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.spring.apiPayLoad.ApiResponse;
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

}

package umc.study.spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.spring.domain.apiPayload.ApiResponse;
import umc.study.spring.dto.MissionResponse;
import umc.study.spring.dto.UserMissionRequest;
import umc.study.spring.service.MissionService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mission")
public class MissionController {

    private final MissionService missionService;

    //가게의 미션을 도전 중인 미션에 추가
    @PostMapping("/accept")
    public ApiResponse<MissionResponse.UserMission> acceptMission(@RequestBody @Valid UserMissionRequest userMissionRequest){
        return ApiResponse.onSuccess(missionService.acceptMission(userMissionRequest));
    }

}

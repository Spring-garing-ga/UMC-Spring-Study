package umc.study.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.study.spring.apiPayLoad.ApiResponse;
import umc.study.spring.converter.MissionConverter;
import umc.study.spring.domain.Mission;
import umc.study.spring.domain.mapping.UserMission;
import umc.study.spring.service.MissionService.MissionQueryService;
import umc.study.spring.validation.annotation.CheckPage;
import umc.study.spring.validation.annotation.ExistUser;
import umc.study.spring.service.MissionService.MissionCommandService;
import umc.study.spring.web.dto.MissionRequestDTO;
import umc.study.spring.web.dto.MissionResponseDTO;
import umc.study.spring.service.MissionService.MissionCommandService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mission")
@Slf4j
@Validated
public class MissionRestController {
    private final MissionCommandService missionService;
    private final MissionQueryService missionQueryService;
    @PostMapping("/")
    public ApiResponse<MissionResponseDTO.AddMissionResultDTO> addMission(@RequestBody @Valid MissionRequestDTO.AddMissionDTO request){
        Mission mission = missionService.addMission(request);
        return ApiResponse.onSuccess(MissionConverter.toAddMissionResultDTO(mission));
    }

    @GetMapping("/{userId}/missions")
    @Operation(summary = "특정 유저의 진행중인 미션 목록 조회 API",description = "특정 유저의 진행중인 미션 목록을 조회하는 API이며, 페이징을 포함합니다. query string으로 페이지 번호를 주세요.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "userId", description = "유저의 아이디, path variable 입니다!"),
            @Parameter(name = "page", description = "페이지 번호, 0번이 1 페이지 입니다.")
    })
    public ApiResponse<MissionResponseDTO.MissionListDTO> getMissionList(@ExistUser @PathVariable(name = "userId") Long userId, @CheckPage @RequestParam(name = "page") Integer page){
        Page<UserMission> userMissionList = missionQueryService.getUserMissionList(userId, page);
        return ApiResponse.onSuccess(MissionConverter.toMissionListDTO(userMissionList));
    }
}

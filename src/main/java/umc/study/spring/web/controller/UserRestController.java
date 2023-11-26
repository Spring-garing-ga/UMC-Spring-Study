package umc.study.spring.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.web.bind.annotation.*;
import umc.study.spring.apiPayLoad.ApiResponse;
import umc.study.spring.converter.UserConverter;
import umc.study.spring.domain.User;
import umc.study.spring.service.UserService.UserCommandService;
import umc.study.spring.service.UserService.UserQueryService;
import umc.study.spring.web.dto.UserRequestDTO;
import umc.study.spring.web.dto.UserResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
@Slf4j
public class UserRestController {
    private final UserCommandService userCommandService;
    private final UserQueryService userQueryService;

    @PostMapping("/")
    public ApiResponse<UserResponseDTO.JoinResultDTO> join(@RequestBody @Valid UserRequestDTO.JoinDTO request){
        log.info("join컨트롤러 호출");
        User user = userCommandService.joinUser(request);
        return ApiResponse.onSuccess(UserConverter.toJoinResultDTO(user));
    }

    @GetMapping("/{memberId}/reviews")
//    @Operation(summary = "사용자의 리뷰 목록 조회 API",description = "사용자가 쓴 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
//    @ApiResponses({
//            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
//            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
//            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
//            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
//    })
//    @Parameters({
//            @Parameter(name = "userId", description = "유저의 아이디, path variable 입니다!")
//    })
    public ApiResponse<UserResponseDTO.ReviewPreViewListDTO> getReviewList(@PathVariable(name="userId") Long userId, @RequestParam(name = "page") Integer page){
        userQueryService.getReviewList(userId, page);
        return null;
    }
}

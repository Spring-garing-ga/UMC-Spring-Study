package umc.study.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import umc.study.spring.apiPayLoad.ApiResponse;
import umc.study.spring.converter.TempConverter;
import umc.study.spring.web.dto.TempResponse;
import umc.study.spring.service.TempService.TempQueryService;

@RestController
@RequestMapping("/temp")
@RequiredArgsConstructor
public class TempRestController {

    private final TempQueryService tempQueryService;

    @GetMapping("/test")
    public ApiResponse<TempResponse.TempTestDTO> testApi(){
        return ApiResponse.onSuccess(TempConverter.toTempTestDTO());
    }

    @GetMapping("/exception")
    public ApiResponse<TempResponse.TempExceptionDTO> exceptionApi(@RequestParam Integer flag){
        tempQueryService.CheckFlag(flag);
        return ApiResponse.onSuccess(TempConverter.toTempExceptionDTO(flag));
    }
}

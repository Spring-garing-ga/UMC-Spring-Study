package umc.study.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.spring.apiPayLoad.ApiResponse;
import umc.study.spring.converter.StoreConverter;
import umc.study.spring.domain.Store;
import umc.study.spring.service.StoreService.StoreCommandService;
import umc.study.spring.web.dto.StoreRequestDTO;
import umc.study.spring.web.dto.StoreResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {
    private final StoreCommandService storeCommandService;

    @PostMapping("/")
    public ApiResponse<StoreResponseDTO.JoinResultDTO> join(@RequestBody @Valid StoreRequestDTO.JoinDto request){
        Store store = storeCommandService.addStore(request);
        return ApiResponse.onSuccess(StoreConverter.toJoinResultDTO(store));
    }
}
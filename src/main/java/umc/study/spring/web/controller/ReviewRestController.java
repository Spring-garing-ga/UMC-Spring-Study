package umc.study.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.study.spring.apiPayLoad.ApiResponse;
import umc.study.spring.converter.ReviewConverter;
import umc.study.spring.domain.Review;
import umc.study.spring.service.ReviewService.ReviewCommandService;
import umc.study.spring.service.ReviewService.ReviewQueryService;
import umc.study.spring.validation.annotation.ExistStore;
import umc.study.spring.web.dto.ReviewRequestDTO;
import umc.study.spring.web.dto.ReviewResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewRestController {
    private final ReviewCommandService reviewCommandService;
    private final ReviewQueryService reviewQueryService;
    @PostMapping("/")
    public ApiResponse<ReviewResponseDTO.WriteResultDTO> write(@RequestBody @Valid ReviewRequestDTO.WriteDTO request){
        Review review = reviewCommandService.writeReview(request);
        return ApiResponse.onSuccess(ReviewConverter.toWriteResultDTO(review));
    }
}

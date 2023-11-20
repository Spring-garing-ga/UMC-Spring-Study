package umc.study.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.spring.apiPayLoad.ApiResponse;
import umc.study.spring.converter.ReviewConverter;
import umc.study.spring.domain.Review;
import umc.study.spring.service.ReviewService.ReviewCommandService;
import umc.study.spring.web.dto.ReviewRequestDTO;
import umc.study.spring.web.dto.ReviewResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewRestController {
    private final ReviewCommandService reviewCommandService;

    @PostMapping("/")
    public ApiResponse<ReviewResponseDTO.WriteResultDTO> write(@RequestBody @Valid ReviewRequestDTO.WriteDTO request){
        Review review = reviewCommandService.writeReview(request);
        return ApiResponse.onSuccess(ReviewConverter.toWriteResultDTO(review));
    }
}

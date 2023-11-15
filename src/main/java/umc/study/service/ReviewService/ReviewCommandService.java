package umc.study.service.ReviewService;

import umc.study.spring.domain.Review;
import umc.study.web.dto.ReviewRequestDTO;

public interface ReviewCommandService {
    Review writeReview(ReviewRequestDTO.WriteDTO request);
}

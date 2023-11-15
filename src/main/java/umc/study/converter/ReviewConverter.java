package umc.study.converter;

import umc.study.spring.domain.Review;
import umc.study.spring.domain.Store;
import umc.study.spring.domain.User;
import umc.study.repository.StoreRepository;
import umc.study.repository.UserRepository;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;

public class ReviewConverter {

    public static ReviewResponseDTO.WriteResultDTO toWriteResultDTO(Review review){
        return ReviewResponseDTO.WriteResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Review toReview(ReviewRequestDTO.WriteDTO request, UserRepository userRepository, StoreRepository storeRepository){
        User user = userRepository.findById(request.getUserId()).orElseThrow(() -> new EntityNotFoundException("User not found"));

        Store store = storeRepository.findById(request.getStoreId()).orElse(null);

        return Review.builder()
                .rating(request.getRating())
                .content(request.getContent())
                .user(user)
                .store(store)
                .build();
    }

}

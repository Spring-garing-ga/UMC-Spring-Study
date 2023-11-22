package umc.study.spring.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.spring.apiPayload.code.status.ErrorStatus;
import umc.study.spring.apiPayload.exception.handler.StoreHandler;
import umc.study.spring.converter.ReviewConverter;
import umc.study.spring.domain.Review;
import umc.study.spring.repository.ReviewRepository;
import umc.study.spring.repository.StoreRepository;
import umc.study.spring.repository.UserRepository;
import umc.study.spring.web.dto.ReviewRequestDTO;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService{
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final StoreRepository storeRepository;

    @Override
    @Transactional
    public Review writeReview(ReviewRequestDTO.WriteDTO request) {
        Review newReview = ReviewConverter.toReview(request, userRepository, storeRepository);
        Boolean isValid = storeRepository.existsById(request.getStoreId());
        if(!isValid){
           throw new StoreHandler(ErrorStatus.STORE_NOT_FOUND);
        }

        return reviewRepository.save(newReview);
    }
}

package umc.study.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.StoreHandler;
import umc.study.converter.ReviewConverter;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.domain.User;
import umc.study.repository.ReviewRepository;
import umc.study.repository.StoreRepository;
import umc.study.repository.UserRepository;
import umc.study.web.dto.ReviewRequestDTO;

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

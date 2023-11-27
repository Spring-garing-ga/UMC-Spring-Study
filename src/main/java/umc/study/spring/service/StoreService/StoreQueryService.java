package umc.study.spring.service.StoreService;

import org.springframework.data.domain.Page;
import umc.study.spring.domain.Mission;
import umc.study.spring.domain.Review;
import umc.study.spring.domain.Store;

import java.util.Optional;

public interface StoreQueryService {
    Optional<Store> findStore(Long id);
    Page<Review> getReviewList(Long storeId, Integer page);

    Page<Mission> getMissionList(Long storeId, Integer page);
}

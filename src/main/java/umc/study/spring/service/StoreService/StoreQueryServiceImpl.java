package umc.study.spring.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.spring.domain.Mission;
import umc.study.spring.domain.Review;
import umc.study.spring.domain.Store;
import umc.study.spring.repository.MissionRepository;
import umc.study.spring.repository.ReviewRepository;
import umc.study.spring.repository.StoreRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreQueryServiceImpl implements StoreQueryService{
    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;
    private final MissionRepository missionRepository;
    @Override
    public Optional<Store> findStore(Long id) {

        return storeRepository.findById(id);
    }

    @Override
    public Page<Review> getReviewList(Long storeId, Integer page) {
        Store store = storeRepository.findById(storeId).get();
        Page<Review> storePage = reviewRepository.findAllByStore(store, PageRequest.of(page, 10));
        return storePage;
    }

    @Override
    public Page<Mission> getMissionList(Long storeId, Integer page){
        Store store = storeRepository.findById(storeId).get();
        Page<Mission> storePage = missionRepository.findAllByStore(store, PageRequest.of(page, 10));
        return storePage;
    }

}

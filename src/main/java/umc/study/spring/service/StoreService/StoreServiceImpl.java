package umc.study.spring.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.spring.apiPayload.code.status.ErrorStatus;
import umc.study.spring.apiPayload.exception.handler.StoreHandler;
import umc.study.spring.domain.Store;
import umc.study.spring.repository.StoreRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreServiceImpl implements StoreService{
    private final StoreRepository storeRepository;
    @Override
    public Store findById(Long id) {
        Store store = storeRepository.findById(id).orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));
        return store;
    }

    @Override
    public boolean isExist(Long id) {
        return storeRepository.existsById(id);
    }
}

package umc.study.spring.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.spring.converter.StoreConverter;
import umc.study.spring.domain.Store;
import umc.study.spring.repository.StoreRepository;
import umc.study.spring.web.dto.StoreRequestDTO;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;

    @Override
    public Store addStore(StoreRequestDTO.JoinDto request) {

        Store newStore = StoreConverter.toStore(request);

        return storeRepository.save(newStore);
    }
}
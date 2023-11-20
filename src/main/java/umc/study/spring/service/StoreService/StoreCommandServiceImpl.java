package umc.study.spring.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.spring.converter.StoreConverter;
import umc.study.spring.domain.Category;
import umc.study.spring.domain.Store;
import umc.study.spring.repository.AddressRepository;
import umc.study.spring.repository.CategoryRepository;
import umc.study.spring.repository.StoreRepository;
import umc.study.spring.web.dto.StoreRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;
    private final AddressRepository addressRepository;
    private final CategoryRepository categoryRepository;

    @Override
    @Transactional
    public Store addStore(StoreRequestDTO.JoinDto request) {

        Store newStore = StoreConverter.toStore(request);
        Category category = categoryRepository.findByName(request.getCategory_name());
        newStore.setCategory(category);
        addressRepository.save(newStore.getAddress());
        return storeRepository.save(newStore);
    }
}
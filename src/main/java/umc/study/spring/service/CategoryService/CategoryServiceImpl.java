package umc.study.spring.service.CategoryService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.spring.repository.CategoryRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository categoryRepository;

    @Override
    public boolean isExist(Long id) {
        return categoryRepository.existsById(id);
    }
}

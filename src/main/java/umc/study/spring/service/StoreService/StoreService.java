package umc.study.spring.service.StoreService;

import umc.study.spring.domain.Store;

import java.util.Optional;

public interface StoreService {
    public Store findById(Long id);
    public boolean isExist(Long id);
}

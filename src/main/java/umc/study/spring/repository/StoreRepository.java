package umc.study.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.spring.domain.Store;

public interface StoreRepository extends JpaRepository<Store,Long> {
}

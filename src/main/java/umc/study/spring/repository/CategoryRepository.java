package umc.study.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.spring.domain.Category;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    public Category findByName(String name);
}

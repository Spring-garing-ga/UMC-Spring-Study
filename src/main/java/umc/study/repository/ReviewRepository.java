package umc.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.spring.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}

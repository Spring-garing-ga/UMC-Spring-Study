package umc.study.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.spring.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
}

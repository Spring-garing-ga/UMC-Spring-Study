package umc.study.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.spring.domain.Mission;
import umc.study.spring.domain.Review;
import umc.study.spring.domain.Store;
import umc.study.spring.domain.User;
import umc.study.spring.domain.mapping.UserMission;

public interface UserMissionRepository extends JpaRepository<UserMission, Long> {
    Page<UserMission> findAllByUser(User user, PageRequest pageRequest);
}

package umc.study.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.spring.domain.mapping.UserMission;

public interface UserMissionRepository extends JpaRepository<UserMission, Long> {

    boolean existsByUserIdAndMissionId(Integer userId, Integer missionId);
}

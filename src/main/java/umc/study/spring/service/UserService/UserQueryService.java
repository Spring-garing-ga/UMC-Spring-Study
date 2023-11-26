package umc.study.spring.service.UserService;

import org.springframework.data.domain.Page;
import umc.study.spring.domain.Review;
import umc.study.spring.domain.User;

import java.util.Optional;

public interface UserQueryService {
    public boolean isExist(Long id);

    Optional<User> findUser(Long id);
    Page<Review> getReviewList(Long userId, Integer page);

}

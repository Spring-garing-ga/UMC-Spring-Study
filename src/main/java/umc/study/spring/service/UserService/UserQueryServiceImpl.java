package umc.study.spring.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.spring.domain.Review;
import umc.study.spring.domain.User;
import umc.study.spring.repository.ReviewRepository;
import umc.study.spring.repository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserQueryServiceImpl implements UserQueryService{

    private final UserRepository userRepository;
    private final ReviewRepository reviewRepository;

    @Override
    public boolean isExist(Long id) {
        return userRepository.existsById(id);
    }

    @Override
    public Optional<User> findUser(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Page<Review> getReviewList(Long userId, Integer page){
        User user = userRepository.findById(userId).get();
        Page<Review> UserPage = reviewRepository.findAllByUser(user, PageRequest.of(page, 10));
        return UserPage;
    }
}

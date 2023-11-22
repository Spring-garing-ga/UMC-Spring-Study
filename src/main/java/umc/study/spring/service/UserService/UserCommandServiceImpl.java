package umc.study.spring.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.spring.apiPayLoad.code.status.ErrorStatus;
import umc.study.spring.apiPayLoad.exception.handler.CategoryHandler;
import umc.study.spring.converter.UserConverter;
import umc.study.spring.converter.UserPreferConverter;
import umc.study.spring.domain.Category;
import umc.study.spring.domain.User;
import umc.study.spring.domain.mapping.UserPrefer;
import umc.study.spring.web.dto.UserRequestDTO;
import umc.study.spring.repository.AddressRepository;
import umc.study.spring.repository.CategoryRepository;
import umc.study.spring.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserCommandServiceImpl implements UserCommandService {
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final AddressRepository addressRepository;
    @Override
    @Transactional
    public User joinUser(UserRequestDTO.JoinDTO request) {
        User user = UserConverter.toUser(request);
        List<Category> categoryList = request.getPreferCategory().stream()
                .map(categoryId -> {
                    return categoryRepository.findById(categoryId).get();
                }).collect(Collectors.toList());
        List<UserPrefer> userPreferList = UserPreferConverter.toMemberPreferList(categoryList);
        userPreferList.forEach(userPrefer -> {userPrefer.setUser(user);});
        addressRepository.save(user.getAddress());
        return userRepository.save(user);
    }

    @Override
    public void checkUser(Integer userId) throws Exception {
        if(!userRepository.existsById(Long.valueOf(userId))) {
            throw new Exception("존재하지 않는 유저입니다.");
        }
    }
}

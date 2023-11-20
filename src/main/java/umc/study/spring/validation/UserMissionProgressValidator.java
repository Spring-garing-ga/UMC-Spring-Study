package umc.study.spring.validation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.spring.repository.UserMissionRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@RequiredArgsConstructor
public class UserMissionProgressValidator implements ConstraintValidator<ProgressUserMission, Object> {

    private final UserMissionRepository userMissionRepository;


    private String userId;

    private String missionId;

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        boolean isValid = userMissionRepository.existsByUserIdAndMissionId(Integer.valueOf(userId), Integer.valueOf(missionId));

        if (isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("존재하지 않는 유저 미션입니다.")
                    .addPropertyNode("missionId")
                    .addConstraintViolation();
        }
        return isValid;
    }

    @Override
    public void initialize(ProgressUserMission constraintAnnotation) {
        this.missionId = constraintAnnotation.missionId();
        this.userId = constraintAnnotation.userId();
    }
}

package umc.study.spring.validation.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.spring.apiPayLoad.code.status.ErrorStatus;
import umc.study.spring.service.UserService.UserQueryService;
import umc.study.spring.validation.annotation.ExistUser;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
@Component
@RequiredArgsConstructor
public class UserExistValidator implements ConstraintValidator<ExistUser, Long> {

    private final UserQueryService userQueryService;
    @Override
    public void initialize(ExistUser constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        boolean isValid = userQueryService.isExist(value);
        if(!isValid){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MEMBER_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;
    }
}

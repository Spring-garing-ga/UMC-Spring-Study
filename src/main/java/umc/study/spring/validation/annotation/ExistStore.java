package umc.study.spring.validation.annotation;

import umc.study.spring.validation.validator.StoreExistValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = StoreExistValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistStore {
    String message() default "해당 가게를 찾을 수 없습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

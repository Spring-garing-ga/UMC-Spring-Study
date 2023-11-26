package umc.study.spring.web.dto;

import lombok.Getter;
import umc.study.spring.validation.annotation.ExistCategories;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

public class UserRequestDTO {
    @Getter
    public static class JoinDTO{
        @NotBlank
        String name;
        @NotBlank
        String nickname;
        @NotNull
        Integer gender;
        @NotNull
        LocalDate birth;
        @Size(min=5,max=12)
        String address;
        @NotNull
        Integer zip_code;
        @NotNull
        String detail;
        @NotNull
        Integer term;
        @ExistCategories
        List<Long> preferCategory;

    }

    @Getter
    public static class ReviewDTO{
        Long id;
        String content;
        float rating;
    }
}

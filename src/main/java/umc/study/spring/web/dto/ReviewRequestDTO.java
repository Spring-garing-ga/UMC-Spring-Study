package umc.study.spring.web.dto;

import lombok.Getter;
import umc.study.spring.validation.annotation.ExistStore;

public class ReviewRequestDTO {
    @Getter
    public static class WriteDTO{
        String content;
        Float rating;
        Long userId;

        @ExistStore
        Long storeId;

    }
}

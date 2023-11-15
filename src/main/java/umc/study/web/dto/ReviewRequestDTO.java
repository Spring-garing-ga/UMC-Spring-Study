package umc.study.web.dto;

import lombok.Getter;
import umc.study.validation.annotation.ExistStores;

public class ReviewRequestDTO {
    @Getter
    public static class WriteDTO{
        String content;
        Float rating;
        Long userId;

        @ExistStores
        Long storeId;

    }
}

package umc.study.spring.web.dto;

import lombok.Getter;
import umc.study.spring.domain.Category;

import java.time.LocalDateTime;

public class StoreRequestDTO {
    @Getter
    public static class JoinDto{
        String name;
        //address
        int zip_code;
        String address;
        String detail;
        int type;
        Category category;
        //category
        String category_name;
    }
}

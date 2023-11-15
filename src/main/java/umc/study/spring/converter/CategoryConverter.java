package umc.study.spring.converter;

import umc.study.spring.domain.Address;
import umc.study.spring.domain.Category;
import umc.study.spring.web.dto.CategoryRequestDTO;

public class CategoryConverter {
    public static Category toCategory(CategoryRequestDTO request){

        return Category.builder()
                .name(request.getName())
                .build();
    }
}

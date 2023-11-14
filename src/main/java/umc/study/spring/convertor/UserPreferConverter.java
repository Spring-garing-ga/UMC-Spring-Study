package umc.study.spring.convertor;

import umc.study.spring.domain.Category;
import umc.study.spring.domain.mapping.UserPrefer;

import java.util.List;
import java.util.stream.Collectors;

public class UserPreferConverter {

    public static List<UserPrefer> toMemberPreferList(List<Category> categoryList){
        return categoryList.stream()
                .map(category ->
                        UserPrefer.builder()
                        .category(category).build()
                ).collect(Collectors.toList());
    }
}

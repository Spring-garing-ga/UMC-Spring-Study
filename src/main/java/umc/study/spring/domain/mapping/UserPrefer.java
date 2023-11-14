package umc.study.spring.domain.mapping;

import lombok.*;
import umc.study.spring.domain.Category;
import umc.study.spring.domain.User;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class UserPrefer {
    @Id
    @GeneratedValue
    Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    Category category;

    //==연관관계 메서드==//
    public void setUser(User user){
        if(this.user != null)
            user.getUserPreferList().remove(this);
        this.user = user;
        user.getUserPreferList().add(this);
    }

    public void setCategory(Category category){
        this.category = category;
    }
}

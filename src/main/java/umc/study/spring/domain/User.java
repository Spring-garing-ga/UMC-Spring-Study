package umc.study.spring.domain;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.boot.autoconfigure.condition.ConditionalOnJava;

import umc.study.spring.domain.common.BaseEntity;
import umc.study.spring.domain.enums.Gender;
import umc.study.spring.domain.mapping.UserPrefer;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@DynamicInsert
@DynamicUpdate
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private Gender gender;
    private LocalDate birth;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    Address address;
    @Column(nullable = false, length = 50)
    String nickname;
    @ColumnDefault("0")
    Integer point;
    int term;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<UserPrefer> userPreferList = new ArrayList<>();
}

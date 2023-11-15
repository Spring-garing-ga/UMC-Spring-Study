package umc.study.spring.domain;

import lombok.*;
import umc.study.spring.domain.common.BaseEntity;
import umc.study.spring.domain.enums.Gender;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    
    @Column(nullable = true)
    private Gender gender;

    @Column(nullable = true)
    private LocalDateTime birth;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    Address address;
}

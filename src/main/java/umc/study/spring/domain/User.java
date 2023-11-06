package umc.study.spring.domain;

import lombok.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnJava;
import umc.study.spring.domain.common.BaseEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;
    @Column(nullable = false, length = 50)
    private String gender;
    private LocalDateTime birth;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    Address address;
    @Column(nullable = false, length = 50)
    String nickname;
    int point;
    int term;
}

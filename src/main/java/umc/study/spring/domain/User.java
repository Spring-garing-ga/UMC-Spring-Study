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
    private String name;
    private String gender;
    private LocalDateTime birth;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    Address address;
}

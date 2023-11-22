package umc.study.spring.domain.mapping;

import lombok.*;
import umc.study.spring.domain.Mission;
import umc.study.spring.domain.User;
import umc.study.spring.domain.common.BaseEntity;
import umc.study.spring.domain.enums.MissionStatus;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class UserMission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'IN_PROGRESS'")
    private MissionStatus status;

    @Column(nullable = false)
    private Integer checkCode;
}

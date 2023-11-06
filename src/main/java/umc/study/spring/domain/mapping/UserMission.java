package umc.study.spring.domain.mapping;

import lombok.*;
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

    @Column(nullable = false)
    private Integer userId;

    @Column(nullable = false)
    private Integer missionId;


    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'IN_PROGRESS'")
    private MissionStatus status;

    @Column(nullable = false)
    private Integer checkCode;
}

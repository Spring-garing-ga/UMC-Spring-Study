package umc.study.domain;

import lombok.*;
import umc.study.domain.common.BaseEntity;
import umc.study.domain.mapping.UserMission;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(nullable = false)
    private Integer goal;

    @Column(nullable = false)
    private Integer point;

    @Column(nullable = false, length = 100)
    private String description;

    @Column(nullable = false)
    private Integer storeId;

    @Column(nullable = false)
    private LocalDateTime deadline;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<UserMission> userMissionList = new ArrayList<>();
}

package umc.study.spring.domain;

import lombok.*;
import umc.study.spring.domain.common.BaseEntity;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ReviewComment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String comment;

    @OneToOne(mappedBy = "reviewComment")
    private Review review;


}

package umc.study.spring.domain;

import lombok.*;
import umc.study.spring.domain.common.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Address extends BaseEntity {
    @Id @GeneratedValue
    Long id;
    int zip_code;
    String address;
    String detail;
    int type;
}

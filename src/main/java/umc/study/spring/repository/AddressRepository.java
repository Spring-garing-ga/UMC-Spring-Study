package umc.study.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.spring.domain.Address;

public interface AddressRepository extends JpaRepository<Address,Long> {
}

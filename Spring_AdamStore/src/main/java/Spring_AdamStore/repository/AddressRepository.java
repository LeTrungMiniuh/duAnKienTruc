package Spring_AdamStore.repository;

import Spring_AdamStore.entity.Address;
import Spring_AdamStore.entity.Branch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    Page<Address> findAllByUserId(Long userId, Pageable pageable);
}

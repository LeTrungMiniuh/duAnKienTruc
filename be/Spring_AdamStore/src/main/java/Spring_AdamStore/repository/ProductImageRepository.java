package Spring_AdamStore.repository;

import Spring_AdamStore.entity.Color;
import Spring_AdamStore.entity.OrderItem;
import Spring_AdamStore.entity.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {

    Set<ProductImage> findAllByIdIn(Set<Long> imageSet);

}

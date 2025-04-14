package Spring_AdamStore.entity;

import Spring_AdamStore.constants.EntityStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Table(name = "tbl_product_image")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long id;

     String publicId;
     String fileName;
     String imageUrl;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "product_id")
     Product product;

}

package Spring_AdamStore.entity;

import Spring_AdamStore.constants.EntityStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_address")
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @JoinColumn(nullable = false)
    Boolean isDefault;

    @JoinColumn(nullable = false)
    String streetDetail;


    @ManyToOne
    @JoinColumn(name = "ward_id", nullable = false)
    Ward ward;

    @ManyToOne
    @JoinColumn(name = "district_id", nullable = false)
     District district;

    @ManyToOne
    @JoinColumn(name = "province_id", nullable = false)
    Province province;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
     User user;

    @OneToMany(mappedBy = "address")
    Set<Order> orders = new HashSet<>();



    @PrePersist
    public void prePersist() {
        if (isDefault == null) {
            this.isDefault = false;
        }
    }
}

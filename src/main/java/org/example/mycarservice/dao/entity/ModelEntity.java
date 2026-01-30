package org.example.mycarservice.dao.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.mycarservice.model.enums.Status;

import java.util.List;

import static jakarta.persistence.EnumType.STRING;
import static lombok.AccessLevel.PRIVATE;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = PRIVATE)
@Table(name = "models")
public class ModelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String modelName;

    String category;

    Integer yearFrom;

    Integer yearTo;

    @Enumerated(STRING)
    Status status;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "brand_id", nullable = false)
    BrandEntity brand;

    @OneToMany(mappedBy = "model", fetch = FetchType.LAZY)
    List<CarEntity> cars;

}

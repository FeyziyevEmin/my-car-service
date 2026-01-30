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
@Table(name = "features")
public class FeatureEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    Integer featureId;

    String name;

    String description;

    String category;

    @Enumerated(STRING)
    Status status;

    @ManyToMany(mappedBy = "features", fetch = FetchType.LAZY)
    List<CarEntity> cars;
}

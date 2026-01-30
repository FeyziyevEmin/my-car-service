package org.example.mycarservice.dao.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.mycarservice.model.enums.Status;

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
@Table(name = "car_details")
public class CarDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String engineNumber;

    String registrationCode;

    String fuelType;

    String engineCapacity;

    String color;

    String insuranceNumber;

    @Enumerated(STRING)
    Status status;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "car_id", nullable = false, unique = true)
    CarEntity car;
}

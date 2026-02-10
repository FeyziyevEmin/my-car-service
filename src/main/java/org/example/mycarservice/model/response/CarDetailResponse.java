package org.example.mycarservice.model.response;

import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.mycarservice.dao.entity.CarEntity;
import org.example.mycarservice.model.enums.Status;

import static lombok.AccessLevel.PRIVATE;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = PRIVATE)
public class CarDetailResponse {

    Integer id;

    String engineNumber;

    String registrationCode;

    String fuelType;

    String engineCapacity;

    Status status;

    String color;

    String insuranceNumber;

}

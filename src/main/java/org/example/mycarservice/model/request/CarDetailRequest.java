package org.example.mycarservice.model.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.mycarservice.dao.entity.CarEntity;

import static lombok.AccessLevel.PRIVATE;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class CarDetailRequest {

    String engineNumber;

    String registrationCode;

    String fuelType;

    String engineCapacity;

    String color;

    String insuranceNumber;

}

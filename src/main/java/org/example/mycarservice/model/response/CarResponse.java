package org.example.mycarservice.model.response;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.mycarservice.dao.entity.CarDetailEntity;
import org.example.mycarservice.dao.entity.FeatureEntity;
import org.example.mycarservice.dao.entity.ModelEntity;
import org.example.mycarservice.model.enums.Status;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = PRIVATE)
public class CarResponse {
    Long id;
    String vin;

    String registrationNumber;

    Integer mileageKm;

    Integer productionYear;

    ModelResponse model;

    Status status;

    CarDetailResponse carDetails;

    List<FeatureResponse> features;
}

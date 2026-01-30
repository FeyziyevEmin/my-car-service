package org.example.mycarservice.model.request;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.mycarservice.dao.entity.CarDetailEntity;
import org.example.mycarservice.dao.entity.FeatureEntity;
import org.example.mycarservice.dao.entity.ModelEntity;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class CarRequest {

    String vin;

    String registrationNumber;

    Integer mileageKm;

    Integer productionYear;

    Integer modelId;

    List<Integer> featureIds;
}

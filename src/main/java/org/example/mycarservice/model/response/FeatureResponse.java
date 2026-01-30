package org.example.mycarservice.model.response;

import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.mycarservice.dao.entity.CarEntity;
import org.example.mycarservice.model.enums.Status;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = PRIVATE)
public class FeatureResponse {
    Integer id;

    String name;

    String description;

    Status status;

    String category;
}

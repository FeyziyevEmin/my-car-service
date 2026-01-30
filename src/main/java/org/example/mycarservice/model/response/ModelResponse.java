package org.example.mycarservice.model.response;

import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.mycarservice.dao.entity.BrandEntity;
import org.example.mycarservice.dao.entity.CarEntity;
import org.example.mycarservice.model.enums.Status;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = PRIVATE)
public class ModelResponse {
    Integer id;

    String modelName;

    String category;

    Integer yearFrom;

    Status status;

    Integer yearTo;

}

package org.example.mycarservice.model.request;

import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.mycarservice.dao.entity.BrandEntity;
import org.example.mycarservice.dao.entity.CarEntity;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class ModelRequest {

    Integer brandId;

    String modelName;

    String category;

    Integer yearFrom;

    Integer yearTo;

}

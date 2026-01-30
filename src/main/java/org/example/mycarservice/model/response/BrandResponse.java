package org.example.mycarservice.model.response;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.mycarservice.model.enums.Status;

import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = PRIVATE)
public class BrandResponse {
    Integer id;
    String name;
    String country;
    Status status;
    List<ModelResponse> models;
}

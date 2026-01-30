package org.example.mycarservice.service.abstraction;

import org.example.mycarservice.model.request.CarDetailRequest;
import org.example.mycarservice.model.request.CarRequest;
import org.example.mycarservice.model.request.ModelRequest;
import org.example.mycarservice.model.response.CarResponse;
import org.example.mycarservice.model.response.ModelResponse;

import java.util.List;

public interface ModelService {
    void saveModel(ModelRequest modelRequest);

    void deleteModel(Long id);

    ModelResponse getModelById(Long id);

    void updateModel(Long id, ModelRequest modelRequest);

    List<ModelResponse> getModels();
}

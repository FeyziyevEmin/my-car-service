package org.example.mycarservice.mapper;

import org.example.mycarservice.dao.entity.ModelEntity;
import org.example.mycarservice.model.request.ModelRequest;
import org.example.mycarservice.model.response.ModelResponse;

public enum ModelMapper {
    MODEL_MAPPER;

    public ModelEntity buildModelEntity(ModelRequest modelRequest) {
        return ModelEntity.builder()
                .modelName(modelRequest.getModelName())
                .category(modelRequest.getCategory())
                .yearFrom(modelRequest.getYearFrom())
                .yearTo(modelRequest.getYearTo())
                .build();
    }

    public ModelResponse buildModelResponse(ModelEntity modelEntity) {
        return ModelResponse.builder()
                .id(modelEntity.getId())
                .modelName(modelEntity.getModelName())
                .category(modelEntity.getCategory())
                .yearFrom(modelEntity.getYearFrom())
                .yearTo(modelEntity.getYearTo())
                .yearTo(modelEntity.getYearFrom())
                .build();
    }

    public void updateModel(ModelEntity modelEntity, ModelRequest modelRequest) {
        modelEntity.setModelName(modelRequest.getModelName());
        modelEntity.setCategory(modelRequest.getCategory());
        modelEntity.setYearFrom(modelRequest.getYearFrom());
        modelEntity.setYearTo(modelRequest.getYearTo());
    }
}

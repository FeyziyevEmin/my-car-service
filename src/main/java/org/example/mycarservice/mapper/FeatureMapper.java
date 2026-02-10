package org.example.mycarservice.mapper;

import org.example.mycarservice.dao.entity.FeatureEntity;
import org.example.mycarservice.model.request.FeatureRequest;
import org.example.mycarservice.model.response.FeatureResponse;

public enum FeatureMapper {
    FEATURE_MAPPER;

    public FeatureEntity buildFeatureEntity(FeatureRequest featureRequest) {
        return FeatureEntity.builder()
                .name(featureRequest.getName())
                .description(featureRequest.getDescription())
                .category(featureRequest.getCategory())
                .build();
    }

    public FeatureResponse buildFeatureResponse(FeatureEntity featureEntity) {
        return FeatureResponse.builder()
                .id(featureEntity.getId())
                .name(featureEntity.getName())
                .description(featureEntity.getDescription())
                .category(featureEntity.getCategory())
                .status(featureEntity.getStatus())
                .build();
    }

    public void updateFeature(FeatureEntity featureEntity, FeatureRequest featureRequest) {
        featureEntity.setName(featureRequest.getName());
        featureEntity.setDescription(featureRequest.getDescription());
        featureEntity.setCategory(featureRequest.getCategory());
    }
}

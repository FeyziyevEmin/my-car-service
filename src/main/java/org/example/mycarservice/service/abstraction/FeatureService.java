package org.example.mycarservice.service.abstraction;

import org.example.mycarservice.model.request.FeatureRequest;
import org.example.mycarservice.model.response.FeatureResponse;

import java.util.List;

public interface FeatureService {

    void saveFeature(FeatureRequest featureRequest);

    void deleteFeature(Long id);

    FeatureResponse getFeatureById(Long id);

    void updateFeature(Long id, FeatureRequest featureRequest);

    List<FeatureResponse> getFeatures();
}

package org.example.mycarservice.service.concrete;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.mycarservice.dao.entity.FeatureEntity;
import org.example.mycarservice.dao.repository.FeatureRepository;
import org.example.mycarservice.exception.ExceptionConstants;
import org.example.mycarservice.exception.NotFoundException;
import org.example.mycarservice.mapper.FeatureMapper;
import org.example.mycarservice.model.enums.Status;
import org.example.mycarservice.model.request.FeatureRequest;
import org.example.mycarservice.model.response.FeatureResponse;
import org.example.mycarservice.service.abstraction.FeatureService;
import org.springframework.stereotype.Service;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;
import static org.example.mycarservice.mapper.FeatureMapper.FEATURE_MAPPER;
import static org.example.mycarservice.model.enums.Status.DELETED;

@Service
@FieldDefaults(level = PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class FeatureServiceImpl implements FeatureService {
    FeatureRepository featureRepository;

    @Override
    public void saveFeature(FeatureRequest featureRequest) {
        FeatureEntity featureEntity = FEATURE_MAPPER.buildFeatureEntity(featureRequest);
        featureRepository.save(featureEntity);
    }

    @Override
    public void deleteFeature(Long id) {
        FeatureEntity featureEntity = fetchFeatureIfExist(id);
        featureEntity.setStatus(DELETED);
        featureRepository.save(featureEntity);
    }

    @Override
    public FeatureResponse getFeatureById(Long id) {
        FeatureEntity featureEntity = fetchFeatureIfExist(id);
        return FEATURE_MAPPER.buildFeatureResponse(featureEntity);
    }

    @Override
    public void updateFeature(Long id, FeatureRequest featureRequest) {
        FeatureEntity featureEntity = fetchFeatureIfExist(id);
        FEATURE_MAPPER.updateFeature(featureEntity, featureRequest);
        featureRepository.save(featureEntity);
    }

    @Override
    public List<FeatureResponse> getFeatures() {
        return featureRepository.findAll().stream()
                .map(FEATURE_MAPPER::buildFeatureResponse)
                .toList();
    }

    private FeatureEntity fetchFeatureIfExist(Long id) {
        return featureRepository.findById(id).orElseThrow(() ->
                new NotFoundException(ExceptionConstants.FEATURE_NOT_FOUND.getCode(),
                        ExceptionConstants.FEATURE_NOT_FOUND.getMessage()));
    }
}

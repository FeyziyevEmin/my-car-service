package org.example.mycarservice.service.concrete;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.mycarservice.dao.entity.BrandEntity;
import org.example.mycarservice.dao.entity.ModelEntity;
import org.example.mycarservice.dao.repository.BrandRepository;
import org.example.mycarservice.dao.repository.ModelRepository;
import org.example.mycarservice.exception.ExceptionConstants;
import org.example.mycarservice.exception.NotFoundException;
import org.example.mycarservice.mapper.ModelMapper;
import org.example.mycarservice.model.enums.Status;
import org.example.mycarservice.model.request.ModelRequest;
import org.example.mycarservice.model.response.ModelResponse;
import org.example.mycarservice.service.abstraction.ModelService;
import org.springframework.stereotype.Service;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;
import static org.example.mycarservice.mapper.ModelMapper.MODEL_MAPPER;

@Service
@FieldDefaults(level = PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ModelServiceImpl implements ModelService {
    ModelRepository modelRepository;

    @Override
    public void saveModel(ModelRequest modelRequest) {
        ModelEntity modelEntity = MODEL_MAPPER.buildModelEntity(modelRequest);
        modelRepository.save(modelEntity);
    }

    @Override
    public void deleteModel(Long id) {
        ModelEntity modelEntity = fetchModelIfExist(id);
        modelEntity.setStatus(Status.DELETED);
        modelRepository.save(modelEntity);
    }

    @Override
    public ModelResponse getModelById(Long id) {
        ModelEntity modelEntity = fetchModelIfExist(id);
        return MODEL_MAPPER.buildModelResponse(modelEntity);
    }

    @Override
    public void updateModel(Long id, ModelRequest modelRequest) {
        ModelEntity modelEntity = fetchModelIfExist(id);
        MODEL_MAPPER.updateModel(modelEntity, modelRequest);
        modelRepository.save(modelEntity);
    }

    @Override
    public List<ModelResponse> getModels() {
        return modelRepository.findAll().stream()
                .map(MODEL_MAPPER::buildModelResponse)
                .toList();
    }

    private ModelEntity fetchModelIfExist(Long id) {
        return modelRepository.findById(id).orElseThrow(() ->
                new NotFoundException(ExceptionConstants.MODEL_NOT_FOUND.getCode(),
                        ExceptionConstants.MODEL_NOT_FOUND.getMessage()));
    }
}

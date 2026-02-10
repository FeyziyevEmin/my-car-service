package org.example.mycarservice.service.concrete;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.mycarservice.dao.entity.BrandEntity;
import org.example.mycarservice.dao.repository.BrandRepository;
import org.example.mycarservice.exception.ExceptionConstants;
import org.example.mycarservice.exception.NotFoundException;
import org.example.mycarservice.mapper.BrandMapper;
import org.example.mycarservice.model.enums.Status;
import org.example.mycarservice.model.request.BrandRequest;
import org.example.mycarservice.model.response.BrandResponse;
import org.example.mycarservice.service.abstraction.BrandService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;
import static org.example.mycarservice.mapper.BrandMapper.BRAND_MAPPER;
import static org.example.mycarservice.model.enums.Status.DELETED;

@Service
@FieldDefaults(level = PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {
    BrandRepository brandRepository;

    @Override
    public void saveBrand(BrandRequest brandRequest) {
        BrandEntity brandEntity = BRAND_MAPPER.buildBrandEntity(brandRequest);
        brandRepository.save(brandEntity);
    }

    @Override
    public void deleteBrand(Long id) {
        BrandEntity brandEntity = fetchBrandIfExist(id);
        brandEntity.setStatus(DELETED);
        brandRepository.save(brandEntity);

    }

    @Override
    public BrandResponse getBrandById(Long id) {
        BrandEntity brandEntity = fetchBrandIfExist(id);
        return BRAND_MAPPER.buildBrandResponse(brandEntity);
    }

    @Override
    public void updateBrand(Long id, BrandRequest brandRequest) {
        BrandEntity brandEntity = fetchBrandIfExist(id);
        BRAND_MAPPER.updateBrand(brandEntity, brandRequest);
        brandRepository.save(brandEntity);
    }

    @Override
    public List<BrandResponse> getAllBrands() {
        return brandRepository.findAll().stream()
                .map(BRAND_MAPPER::buildBrandResponse)
                .toList();
    }

    private BrandEntity fetchBrandIfExist(Long id) {
        return brandRepository.findById(id).orElseThrow(() ->
                new NotFoundException(ExceptionConstants.BRAND_NOT_FOUND.getCode(),
                                      ExceptionConstants.BRAND_NOT_FOUND.getMessage()));
    }
}

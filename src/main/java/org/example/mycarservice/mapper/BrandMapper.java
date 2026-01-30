package org.example.mycarservice.mapper;

import org.example.mycarservice.dao.entity.BrandEntity;
import org.example.mycarservice.model.request.BrandRequest;
import org.example.mycarservice.model.response.BrandResponse;

public enum BrandMapper {
    BRAND_MAPPER;

    public BrandEntity buildBrandEntity(BrandRequest brandRequest){
        return BrandEntity.builder()
                .name(brandRequest.getName())
                .country(brandRequest.getCountry())
                .build();
    }

    public BrandResponse buildBrandResponse(BrandEntity brandEntity){
        return BrandResponse.builder()
                .id(brandEntity.getId())
                .name(brandEntity.getName())
                .country(brandEntity.getCountry())
                .status(brandEntity.getStatus())
                .build();
    }

    public void updateBrand(BrandEntity brandEntity, BrandRequest brandRequest) {
        brandEntity.setName(brandRequest.getName());
        brandEntity.setCountry(brandRequest.getCountry());
    }
}

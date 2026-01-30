package org.example.mycarservice.service.abstraction;

import org.example.mycarservice.model.request.BrandRequest;
import org.example.mycarservice.model.response.BrandResponse;

import java.util.List;

public interface BrandService {
    void saveBrand(BrandRequest brandRequest);

    void deleteBrand(Long id);

    BrandResponse getBrandById(Long id);

    void updateBrand(Long id, BrandRequest brandRequest);

    List<BrandResponse> getAllBrands();
}

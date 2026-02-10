package org.example.mycarservice.controller;

import org.example.mycarservice.model.request.BrandRequest;
import org.example.mycarservice.model.response.BrandResponse;
import org.example.mycarservice.service.abstraction.BrandService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/brands")
public class BrandController {
    BrandService brandService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void saveBrand(@RequestBody BrandRequest brandRequest) {
        brandService.saveBrand(brandRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBrand(@PathVariable Long id) {
        brandService.deleteBrand(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    BrandResponse getBrandById(@PathVariable Long id) {
        return brandService.getBrandById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateBrand(@PathVariable Long id, @RequestBody BrandRequest brandRequest) {
        brandService.updateBrand(id, brandRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<BrandResponse> getAllBrands() {
        return brandService.getAllBrands();
    }

}

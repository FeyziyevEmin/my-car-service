package org.example.mycarservice.controller;

import org.example.mycarservice.model.request.FeatureRequest;
import org.example.mycarservice.model.response.FeatureResponse;
import org.example.mycarservice.service.abstraction.FeatureService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/features")
public class FeatureController {
    FeatureService featureService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveFeature(@RequestBody FeatureRequest featureRequest) {
        featureService.saveFeature(featureRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteFeature(@PathVariable Long id) {
        featureService.deleteFeature(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    FeatureResponse getFeatureById(@PathVariable Long id) {
        return featureService.getFeatureById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateFeature(@PathVariable Long id, @RequestBody FeatureRequest featureRequest) {
        featureService.updateFeature(id, featureRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<FeatureResponse> getFeatures() {
        return featureService.getFeatures();
    }
}

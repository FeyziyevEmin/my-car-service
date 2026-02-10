package org.example.mycarservice.controller;

import org.example.mycarservice.model.request.ModelRequest;
import org.example.mycarservice.model.response.ModelResponse;
import org.example.mycarservice.service.abstraction.ModelService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/models")
public class ModelController {
    ModelService modelService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveModel(@RequestBody ModelRequest modelRequest) {
        modelService.saveModel(modelRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteModel(@PathVariable Long id) {
        modelService.deleteModel(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    ModelResponse getModelById(@PathVariable Long id) {
        return modelService.getModelById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateModel(@PathVariable Long id, @RequestBody ModelRequest modelRequest) {
        modelService.updateModel(id, modelRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<ModelResponse> getModels() {
        return modelService.getModels();
    }
}


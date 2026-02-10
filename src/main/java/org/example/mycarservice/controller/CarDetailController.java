package org.example.mycarservice.controller;

import org.example.mycarservice.model.request.CarDetailRequest;
import org.example.mycarservice.model.response.CarDetailResponse;
import org.example.mycarservice.service.abstraction.CarDetailService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/carDetails")
public class CarDetailController {
    CarDetailService carDetailService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCarDetail(@RequestBody CarDetailRequest carDetailRequest) {
        carDetailService.saveCarDetail(carDetailRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCarDetail(@PathVariable Long id) {
        carDetailService.deleteCarDetail(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    CarDetailResponse getCarDetailById(@PathVariable Long id) {
        return carDetailService.getCarDetailById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCarDetail(@PathVariable Long id, @RequestBody CarDetailRequest carDetailRequest) {
        carDetailService.updateCarDetail(id, carDetailRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<CarDetailResponse> getCarDetails(){
        return carDetailService.getCarDetails();
    }
}

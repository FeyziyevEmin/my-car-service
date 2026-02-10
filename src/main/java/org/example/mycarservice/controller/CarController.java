package org.example.mycarservice.controller;

import org.example.mycarservice.model.request.CarRequest;
import org.example.mycarservice.model.response.CarResponse;
import org.example.mycarservice.service.abstraction.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/cars")
public class CarController {
    CarService carService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCar(@RequestBody CarRequest carRequest) {
        carService.saveCar(carRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    CarResponse getCarById(@PathVariable Long id) {
        return  carService.getCarById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCar(@PathVariable Long id, @RequestBody CarRequest carRequest) {
        carService.updateCar(id, carRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<CarResponse> getAllCars() {
        return  carService.getAllCars();
    }
}

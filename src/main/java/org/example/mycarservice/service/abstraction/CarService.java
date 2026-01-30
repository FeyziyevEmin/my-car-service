package org.example.mycarservice.service.abstraction;

import org.example.mycarservice.model.request.CarRequest;
import org.example.mycarservice.model.response.CarResponse;

import java.util.List;

public interface CarService {
    void saveCar(CarRequest carRequest);

    void deleteCar(Long id);

    CarResponse getCarById(Long id);

    void updateCar(Long id, CarRequest carRequest);

    List<CarResponse> getAllCars();
}

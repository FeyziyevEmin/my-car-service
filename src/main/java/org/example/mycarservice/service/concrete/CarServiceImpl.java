package org.example.mycarservice.service.concrete;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.mycarservice.dao.entity.CarEntity;
import org.example.mycarservice.dao.repository.CarRepository;
import org.example.mycarservice.exception.ExceptionConstants;
import org.example.mycarservice.exception.NotFoundException;
import org.example.mycarservice.mapper.CarMapper;
import org.example.mycarservice.model.request.CarRequest;
import org.example.mycarservice.model.response.CarResponse;
import org.example.mycarservice.service.abstraction.CarService;
import org.springframework.stereotype.Service;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;
import static org.example.mycarservice.mapper.CarMapper.CAR_MAPPER;
import static org.example.mycarservice.model.enums.Status.DELETED;
import static org.example.mycarservice.model.enums.Status.IN_PROGRESS;

@Service
@FieldDefaults(level = PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    CarRepository carRepository;

    @Override
    public void saveCar(CarRequest carRequest) {
        CarEntity carEntity = CAR_MAPPER.buildCarEntity(carRequest);
        carRepository.save(carEntity);
    }

    @Override
    public void deleteCar(Long id) {
        CarEntity carEntity = fetchCarIfExist(id);
        carEntity.setStatus(DELETED);
        carRepository.save(carEntity);
    }

    @Override
    public CarResponse getCarById(Long id) {
        CarEntity carEntity = fetchCarIfExist(id);
        return CAR_MAPPER.buildCarResponse(carEntity);
    }

    @Override
    public void updateCar(Long id, CarRequest carRequest) {
        CarEntity carEntity = fetchCarIfExist(id);
        CAR_MAPPER.updateCar(carEntity, carRequest);
        carRepository.save(carEntity);
    }

    @Override
    public List<CarResponse> getAllCars() {
        return carRepository.findAll().stream()
                .map(CAR_MAPPER::buildCarResponse)
                .toList();
    }

    private CarEntity fetchCarIfExist(Long id) {
        return carRepository.findById(id).orElseThrow(() ->
                new NotFoundException(ExceptionConstants.CAR_NOT_FOUND.getCode(),
                                      ExceptionConstants.CAR_NOT_FOUND.getMessage()));
    }
}

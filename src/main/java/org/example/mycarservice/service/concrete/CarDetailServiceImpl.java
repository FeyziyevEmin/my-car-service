package org.example.mycarservice.service.concrete;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.mycarservice.dao.entity.CarDetailEntity;
import org.example.mycarservice.dao.repository.CarDetailRepository;
import org.example.mycarservice.dao.repository.CarRepository;
import org.example.mycarservice.exception.ExceptionConstants;
import org.example.mycarservice.exception.NotFoundException;
import org.example.mycarservice.model.enums.Status;
import org.example.mycarservice.model.request.CarDetailRequest;
import org.example.mycarservice.model.response.CarDetailResponse;
import org.example.mycarservice.service.abstraction.CarDetailService;
import org.springframework.stereotype.Service;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;
import static org.example.mycarservice.mapper.CarDetailMapper.*;

@Service
@FieldDefaults(level = PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class CarDetailServiceImpl implements CarDetailService {
    CarDetailRepository carDetailRepository;
    private final CarRepository carRepository;

    @Override
    public void saveCarDetail(CarDetailRequest carDetailRequest) {
        CarDetailEntity carDetailEntity = CAR_DETAIL_MAPPER.buildCarDetailEntity(carDetailRequest);
        carDetailRepository.save(carDetailEntity);
    }

    @Override
    public void deleteCarDetail(Long id) {
        CarDetailEntity carDetailEntity = fetchCarDetailIfExist(id);
        carDetailEntity.setStatus(Status.DELETED);
        carDetailRepository.save(carDetailEntity);
    }

    @Override
    public CarDetailResponse getCarDetailById(Long id) {
        CarDetailEntity carDetailEntity = fetchCarDetailIfExist(id);
        return CAR_DETAIL_MAPPER.buildCarDetailResponse(carDetailEntity);
    }

    @Override
    public void updateCarDetail(Long id, CarDetailRequest carDetailRequest) {
        CarDetailEntity carDetailEntity = fetchCarDetailIfExist(id);
        CAR_DETAIL_MAPPER.updateCarDetail(carDetailEntity, carDetailRequest);
        carDetailRepository.save(carDetailEntity);
    }

    @Override
    public List<CarDetailResponse> getCarDetails() {
        return carDetailRepository.findAll().stream()
                .map(CAR_DETAIL_MAPPER::buildCarDetailResponse)
                .toList();
    }

    private CarDetailEntity fetchCarDetailIfExist(Long id) {
        return carDetailRepository.findById(id).orElseThrow(() ->
                new NotFoundException(ExceptionConstants.BRAND_NOT_FOUND.getCode(),
                                      ExceptionConstants.CAR_DETAIL_NOT_FOUND.getMessage()));
    }
}

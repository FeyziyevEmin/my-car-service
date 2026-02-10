package org.example.mycarservice.mapper;

import org.example.mycarservice.dao.entity.CarDetailEntity;
import org.example.mycarservice.model.request.CarDetailRequest;
import org.example.mycarservice.model.response.CarDetailResponse;

public enum CarDetailMapper {
    CAR_DETAIL_MAPPER;

    public CarDetailEntity buildCarDetailEntity(CarDetailRequest carDetailRequest) {
        return CarDetailEntity.builder()
                .engineNumber(carDetailRequest.getEngineNumber())
                .registrationCode(carDetailRequest.getRegistrationCode())
                .fuelType(carDetailRequest.getFuelType())
                .engineCapacity(carDetailRequest.getEngineCapacity())
                .color(carDetailRequest.getColor())
                .insuranceNumber(carDetailRequest.getInsuranceNumber())
                .build();
    }

    public CarDetailResponse buildCarDetailResponse(CarDetailEntity carDetailEntity) {
        return CarDetailResponse.builder()
                .id(carDetailEntity.getId())
                .engineNumber(carDetailEntity.getEngineNumber())
                .registrationCode(carDetailEntity.getRegistrationCode())
                .fuelType(carDetailEntity.getFuelType())
                .engineCapacity(carDetailEntity.getEngineCapacity())
                .status(carDetailEntity.getStatus())
                .color(carDetailEntity.getColor())
                .insuranceNumber(carDetailEntity.getInsuranceNumber())
                .build();
    }

    public void updateCarDetail(CarDetailEntity carDetailEntity, CarDetailRequest carDetailRequest) {
        carDetailEntity.setFuelType(carDetailRequest.getFuelType());
        carDetailEntity.setColor(carDetailRequest.getColor());
        carDetailEntity.setInsuranceNumber(carDetailRequest.getInsuranceNumber());
        carDetailEntity.setEngineCapacity(carDetailRequest.getEngineCapacity());
    }
}

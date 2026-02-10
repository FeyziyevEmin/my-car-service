package org.example.mycarservice.mapper;

import org.example.mycarservice.dao.entity.CarEntity;
import org.example.mycarservice.model.request.CarRequest;
import org.example.mycarservice.model.response.CarResponse;

public enum CarMapper {
    CAR_MAPPER;

    public CarEntity buildCarEntity(CarRequest carRequest) {
        return CarEntity.builder()
                .vin(carRequest.getVin())
                .registrationNumber(carRequest.getRegistrationNumber())
                .mileageKm(carRequest.getMileageKm())
                .productionYear(carRequest.getProductionYear())
                .build();
    }

    public CarResponse buildCarResponse(CarEntity carEntity) {
        return CarResponse.builder()
                .id(carEntity.getId())
                .vin(carEntity.getVin())
                .registrationNumber(carEntity.getRegistrationNumber())
                .mileageKm(carEntity.getMileageKm())
                .productionYear(carEntity.getProductionYear())
                .status(carEntity.getStatus())
                .build();
    }

    public void updateCar(CarEntity carEntity, CarRequest carRequest){
        carEntity.setVin(carRequest.getVin());
        carEntity.setRegistrationNumber( carRequest.getRegistrationNumber());
        carEntity.setMileageKm(carRequest.getMileageKm());
        carEntity.setProductionYear(carRequest.getProductionYear());
    }
}

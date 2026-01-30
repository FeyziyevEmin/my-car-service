package org.example.mycarservice.service.abstraction;

import org.example.mycarservice.model.request.CarDetailRequest;
import org.example.mycarservice.model.response.CarDetailResponse;

import java.util.List;

public interface CarDetailService {
    void saveCarDetail(CarDetailRequest carDetailRequest);

    void deleteCarDetail(Long id);

    CarDetailResponse getCarDetailById(Long id);

    void updateCarDetail(Long id, CarDetailRequest carDetailRequest);

    List<CarDetailResponse>  getCarDetails();
}

package org.example.mycarservice.dao.repository;

import org.example.mycarservice.dao.entity.CarDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarDetailRepository extends JpaRepository<CarDetailEntity, Long> {
}

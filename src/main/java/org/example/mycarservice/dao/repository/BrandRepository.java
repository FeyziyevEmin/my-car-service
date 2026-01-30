package org.example.mycarservice.dao.repository;

import org.example.mycarservice.dao.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<BrandEntity, Long> {
}

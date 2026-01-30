package org.example.mycarservice.dao.repository;

import org.example.mycarservice.dao.entity.FeatureEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeatureRepository extends JpaRepository<FeatureEntity, Long> {
}

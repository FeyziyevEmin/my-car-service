package org.example.mycarservice.dao.repository;

import org.example.mycarservice.dao.entity.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<ModelEntity, Long> {
}

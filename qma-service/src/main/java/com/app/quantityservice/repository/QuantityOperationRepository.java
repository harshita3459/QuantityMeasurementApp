package com.app.quantityservice.repository;

import com.app.quantityservice.entity.QuantityOperation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface QuantityOperationRepository extends JpaRepository<QuantityOperation, Long> {

    List<QuantityOperation> findByOperation(String operation);

    List<QuantityOperation> findByMeasurementType(String measurementType);

    long countByOperation(String operation);
}

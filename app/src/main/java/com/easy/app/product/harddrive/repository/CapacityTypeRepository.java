package com.easy.app.product.harddrive.repository;

import com.easy.app.product.harddrive.model.type.HardDriveCapacityType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CapacityTypeRepository extends JpaRepository<HardDriveCapacityType, Long> {
}

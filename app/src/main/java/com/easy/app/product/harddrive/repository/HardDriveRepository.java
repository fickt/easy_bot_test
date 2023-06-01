package com.easy.app.product.harddrive.repository;

import com.easy.app.product.harddrive.model.entity.HardDrive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HardDriveRepository extends JpaRepository<HardDrive, String> {
}

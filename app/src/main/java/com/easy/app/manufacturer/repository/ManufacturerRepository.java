package com.easy.app.manufacturer.repository;

import com.easy.app.manufacturer.entity.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, String> {
}

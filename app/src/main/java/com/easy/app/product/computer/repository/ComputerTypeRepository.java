package com.easy.app.product.computer.repository;

import com.easy.app.product.computer.model.type.ComputerType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComputerTypeRepository extends JpaRepository<ComputerType, Long> {
}

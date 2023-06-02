package com.easy.app.product.monitor.repository;

import com.easy.app.product.monitor.model.entity.Monitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonitorRepository extends JpaRepository<Monitor, String> {
}

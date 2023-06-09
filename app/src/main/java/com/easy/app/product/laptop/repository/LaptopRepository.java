package com.easy.app.product.laptop.repository;

import com.easy.app.product.laptop.model.entity.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, String> {
}

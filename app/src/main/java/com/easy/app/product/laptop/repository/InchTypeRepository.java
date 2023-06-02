package com.easy.app.product.laptop.repository;

import com.easy.app.product.laptop.model.type.InchType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InchTypeRepository extends JpaRepository<InchType, Long> {
}

package com.easy.app.manufacturer.service;

import com.easy.app.manufacturer.entity.Manufacturer;
import com.easy.app.manufacturer.repository.ManufacturerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ManufacturerServiceImpl implements ManufacturerService {
    private final ManufacturerRepository repository;

    @Override
    public void handleManufacturer(Manufacturer manufacturer) {
        if (!repository.existsById(manufacturer.getName())) {
            repository.save(manufacturer);
        }
    }
}

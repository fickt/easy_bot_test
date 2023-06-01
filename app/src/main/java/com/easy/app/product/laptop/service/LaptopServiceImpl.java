package com.easy.app.product.laptop.service;

import com.easy.app.product.laptop.exception.LaptopAlreadyExists;
import com.easy.app.product.laptop.exception.LaptopNotFoundException;
import com.easy.app.product.laptop.model.dto.LaptopDto;
import com.easy.app.product.laptop.model.dto.LaptopDtoConverter;
import com.easy.app.product.laptop.repository.LaptopRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.easy.app.product.laptop.model.dto.LaptopDtoConverter.fromDto;
import static com.easy.app.product.laptop.model.dto.LaptopDtoConverter.toDto;

@AllArgsConstructor
@Service
public class LaptopServiceImpl implements LaptopService {
    private static final String MSG_LAPTOP_NOT_FOUND = "Laptop with serial number: \"%s\" has not been found!";
    private static final String MSG_LAPTOP_ALREADY_EXISTS = "Laptop with serial number: \"%s\" already exists!";

    private final LaptopRepository repository;

    @Override
    public List<LaptopDto> getLaptops() {
        return repository.findAll()
                .stream()
                .map(LaptopDtoConverter::toDto)
                .toList();
    }

    @Override
    public LaptopDto getLaptopBySerialNumber(String serialNumber) {
        var laptop = repository.findById(serialNumber)
                .orElseThrow(() -> null);

        return toDto(laptop);
    }

    @Override
    public LaptopDto editLaptop(LaptopDto laptopDto) {
        var laptop = repository.findById(laptopDto.getSerialNumber())
                .orElseThrow(() -> {
                    throw new LaptopNotFoundException(String.format(MSG_LAPTOP_NOT_FOUND, laptopDto.getSerialNumber()));
                });

        if (laptopDto.getInchType() != null) {
            laptop.setInchType(laptopDto.getInchType());
        }

        if (laptopDto.getPrice() != null) {
            laptop.setPrice(laptopDto.getPrice());
        }

        if (laptopDto.getQuantity() != null) {
            laptop.setQuantity(laptop.getQuantity());
        }

        if (laptopDto.getManufacturer() != null) {
            laptop.setManufacturer(laptopDto.getManufacturer());
        }

        return toDto(repository.save(laptop));
    }

    @Override
    public LaptopDto addLaptop(LaptopDto laptopDto) {
        if (repository.existsById(laptopDto.getSerialNumber())) {
            throw new LaptopAlreadyExists(String.format(MSG_LAPTOP_ALREADY_EXISTS, laptopDto.getSerialNumber()));
        }

        return toDto(repository.save(fromDto(laptopDto)));
    }
}

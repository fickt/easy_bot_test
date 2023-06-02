package com.easy.app.product.laptop.service;

import com.easy.app.manufacturer.service.ManufacturerService;
import com.easy.app.product.laptop.exception.InchTypeNotFoundException;
import com.easy.app.product.laptop.exception.LaptopAlreadyExists;
import com.easy.app.product.laptop.exception.LaptopNotFoundException;
import com.easy.app.product.laptop.model.dto.LaptopDto;
import com.easy.app.product.laptop.model.dto.LaptopDtoConverter;
import com.easy.app.product.laptop.model.dto.NewLaptopRequestDto;
import com.easy.app.product.laptop.model.type.InchType;
import com.easy.app.product.laptop.repository.InchTypeRepository;
import com.easy.app.product.laptop.repository.LaptopRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.easy.app.product.laptop.model.dto.LaptopDtoConverter.*;

@AllArgsConstructor
@Service
public class LaptopServiceImpl implements LaptopService {
    private static final String MSG_LAPTOP_NOT_FOUND = "Laptop with serial number: %s has not been found!";
    private static final String MSG_LAPTOP_ALREADY_EXISTS = "Laptop with serial number: %s already exists!";
    private static final String MSG_INCH_TYPE_NOT_FOUND = "Inch type with id: %s has not been found!";

    private final LaptopRepository laptopRepository;
    private final InchTypeRepository inchTypeRepository;
    private final ManufacturerService manufacturerService;

    @Override
    public List<LaptopDto> getLaptops() {
        return laptopRepository.findAll()
                .stream()
                .map(LaptopDtoConverter::toDto)
                .toList();
    }

    @Override
    public LaptopDto getLaptopBySerialNumber(String serialNumber) {
        var laptop = laptopRepository.findById(serialNumber)
                .orElseThrow(() -> new LaptopNotFoundException(String.format(MSG_LAPTOP_NOT_FOUND, serialNumber)));

        return toDto(laptop);
    }

    @Override
    public LaptopDto editLaptop(NewLaptopRequestDto laptopDto) {
        var laptop = laptopRepository.findById(laptopDto.getSerialNumber())
                .orElseThrow(() -> {
                    throw new LaptopNotFoundException(String.format(MSG_LAPTOP_NOT_FOUND, laptopDto.getSerialNumber()));
                });

        if (laptopDto.getInchTypeId() != null) {
            var type = getInchTypeById(laptopDto.getInchTypeId());
            laptop.setInchType(type);
        }

        if (laptopDto.getPrice() != null) {
            laptop.setPrice(laptopDto.getPrice());
        }

        if (laptopDto.getQuantity() != null) {
            laptop.setQuantity(laptopDto.getQuantity());
        }

        if (laptopDto.getManufacturer() != null) {
            manufacturerService.handleManufacturer(laptopDto.getManufacturer());
            laptop.setManufacturer(laptopDto.getManufacturer());
        }

        return toDto(laptopRepository.save(laptop));
    }

    @Override
    public LaptopDto addLaptop(NewLaptopRequestDto newLaptopDto) {
        if (laptopRepository.existsById(newLaptopDto.getSerialNumber())) {
            throw new LaptopAlreadyExists(String.format(MSG_LAPTOP_ALREADY_EXISTS, newLaptopDto.getSerialNumber()));
        }
        manufacturerService.handleManufacturer(newLaptopDto.getManufacturer());
        var type = getInchTypeById(newLaptopDto.getInchTypeId());
        var laptopDto = fromNewDtoToDto(newLaptopDto);
        laptopDto.setInchType(type);
        return toDto(laptopRepository.save(fromDto(laptopDto)));
    }

    private InchType getInchTypeById(Long id) {
        return inchTypeRepository.findById(id)
                .orElseThrow(() -> new InchTypeNotFoundException(String.format(MSG_INCH_TYPE_NOT_FOUND, id)));
    }
}

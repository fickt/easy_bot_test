package com.easy.app.product.harddrive.service;

import com.easy.app.manufacturer.service.ManufacturerService;
import com.easy.app.product.harddrive.exception.CapacityTypeNotFoundException;
import com.easy.app.product.harddrive.exception.HardDriveAlreadyExists;
import com.easy.app.product.harddrive.exception.HardDriveNotFound;
import com.easy.app.product.harddrive.model.dto.HardDriveDto;
import com.easy.app.product.harddrive.model.dto.HardDriveDtoConverter;
import com.easy.app.product.harddrive.model.dto.NewHardDriveRequestDto;
import com.easy.app.product.harddrive.model.type.HardDriveCapacityType;
import com.easy.app.product.harddrive.repository.CapacityTypeRepository;
import com.easy.app.product.harddrive.repository.HardDriveRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.easy.app.product.harddrive.model.dto.HardDriveDtoConverter.*;

@Service
@AllArgsConstructor
public class HardDriveServiceImpl implements HardDriveService {
    public static final String MSG_HARD_DRIVE_NOT_FOUND = "Hard drive with serial number: %s has not been found!";
    public static final String MSG_HARD_DRIVE_ALREADY_EXISTS = "Hard drive with serial number: %s already exists!";
    public static final String MSG_CAPACITY_TYPE_NOT_FOUND = "Capacity with id: %s has not been found!";

    private final HardDriveRepository hardDriverepository;
    private final CapacityTypeRepository capacityTypeRepository;
    private final ManufacturerService manufacturerService;

    @Override
    public List<HardDriveDto> getHardDrives() {
        return hardDriverepository.findAll()
                .stream()
                .map(HardDriveDtoConverter::toDto)
                .toList();
    }

    @Override
    public HardDriveDto getHardDriveBySerialNumber(String serialNumber) {
        var hardDrive = hardDriverepository.findById(serialNumber)
                .orElseThrow(() -> new HardDriveNotFound(String.format(MSG_HARD_DRIVE_NOT_FOUND, serialNumber)));
        return toDto(hardDrive);
    }

    @Override
    public HardDriveDto editHardDrive(NewHardDriveRequestDto hardDriveDto) {
        var hardDrive = hardDriverepository.findById(hardDriveDto.getSerialNumber())
                .orElseThrow(() -> new HardDriveNotFound(String.format(MSG_HARD_DRIVE_NOT_FOUND, hardDriveDto.getSerialNumber())));

        if (hardDriveDto.getCapacityTypeId() != null) {
            var type = getCapacityTypeById(hardDriveDto.getCapacityTypeId());
            hardDrive.setCapacityType(type);
        }

        if (hardDriveDto.getPrice() != null) {
            hardDrive.setPrice(hardDriveDto.getPrice());
        }

        if (hardDriveDto.getQuantity() != null) {
            hardDrive.setQuantity(hardDriveDto.getQuantity());
        }

        if (hardDriveDto.getManufacturer() != null) {
            manufacturerService.handleManufacturer(hardDriveDto.getManufacturer());
            hardDrive.setManufacturer(hardDriveDto.getManufacturer());
        }

        return toDto(hardDriverepository.save(hardDrive));
    }

    @Override
    public HardDriveDto addHardDrive(NewHardDriveRequestDto newHardDriveDto) {
        if (hardDriverepository.existsById(newHardDriveDto.getSerialNumber())) {
            throw new HardDriveAlreadyExists(String.format(MSG_HARD_DRIVE_ALREADY_EXISTS, newHardDriveDto.getSerialNumber()));
        }

        manufacturerService.handleManufacturer(newHardDriveDto.getManufacturer());
        var type = getCapacityTypeById(newHardDriveDto.getCapacityTypeId());
        var hardDriveDto = fromNewDtoToDto(newHardDriveDto);
        hardDriveDto.setCapacityType(type);
        return toDto(hardDriverepository.save(fromDto(hardDriveDto)));
    }

    private HardDriveCapacityType getCapacityTypeById(Long id) {
        return capacityTypeRepository.findById(id)
                .orElseThrow(() -> new CapacityTypeNotFoundException(String.format(MSG_CAPACITY_TYPE_NOT_FOUND, id)));
    }
}

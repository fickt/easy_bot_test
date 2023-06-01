package com.easy.app.product.harddrive.service;

import com.easy.app.product.harddrive.exception.HardDriveAlreadyExists;
import com.easy.app.product.harddrive.exception.HardDriveNotFound;
import com.easy.app.product.harddrive.model.dto.HardDriveDto;
import com.easy.app.product.harddrive.model.dto.HardDriveDtoConverter;
import com.easy.app.product.harddrive.repository.HardDriveRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.easy.app.product.harddrive.model.dto.HardDriveDtoConverter.fromDto;
import static com.easy.app.product.harddrive.model.dto.HardDriveDtoConverter.toDto;

@Service
@AllArgsConstructor
public class HardDriveServiceImpl implements HardDriveService {
    public static final String MSG_HARD_DRIVE_NOT_FOUND = "Hard drive with serial number: \"%s\" has not been found!";
    public static final String MSG_HARD_DRIVE_ALREADY_EXISTS = "Hard drive with serial number: \"%s\" already exists!";
    private final HardDriveRepository repository;

    @Override
    public List<HardDriveDto> getHardDrives() {
        return repository.findAll()
                .stream()
                .map(HardDriveDtoConverter::toDto)
                .toList();
    }

    @Override
    public HardDriveDto getHardDriveBySerialNumber(String serialNumber) {
        var hardDrive = repository.findById(serialNumber)
                .orElseThrow(() -> {
                    throw new HardDriveNotFound(String.format(MSG_HARD_DRIVE_NOT_FOUND, serialNumber));
                });
        return toDto(hardDrive);
    }

    @Override
    public HardDriveDto editHardDrive(HardDriveDto hardDriveDto) {
        var hardDrive = repository.findById(hardDriveDto.getSerialNumber())
                .orElseThrow(() -> {
                    throw new HardDriveNotFound(String.format(MSG_HARD_DRIVE_NOT_FOUND, hardDriveDto.getSerialNumber()));
                });

        if (hardDriveDto.getCapacityType() != null) {
            hardDrive.setCapacityType(hardDriveDto.getCapacityType());
        }

        if (hardDriveDto.getPrice() != null) {
            hardDrive.setPrice(hardDriveDto.getPrice());
        }

        if (hardDriveDto.getQuantity() != null) {
            hardDrive.setQuantity(hardDriveDto.getQuantity());
        }

        if (hardDriveDto.getSerialNumber() != null) {
            hardDrive.setSerialNumber(hardDriveDto.getSerialNumber());
        }

        if (hardDriveDto.getManufacturer() != null) {
            hardDrive.setManufacturer(hardDriveDto.getManufacturer());
        }

        return toDto(repository.save(hardDrive));
    }

    @Override
    public HardDriveDto addHardDrive(HardDriveDto hardDriveDto) {
        if (repository.existsById(hardDriveDto.getSerialNumber())) {
            throw new HardDriveAlreadyExists(String.format(MSG_HARD_DRIVE_ALREADY_EXISTS, hardDriveDto.getSerialNumber()));
        }

        return toDto(repository.save(fromDto(hardDriveDto)));
    }
}

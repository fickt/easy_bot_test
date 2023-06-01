package com.easy.app.product.harddrive.model.dto;

import com.easy.app.product.harddrive.model.entity.HardDrive;

public class HardDriveDtoConverter {
    public static HardDriveDto toDto(HardDrive hardDrive) {
        var hardDriveDto = new HardDriveDto();
        hardDriveDto.setCapacityType(hardDrive.getCapacityType());
        hardDriveDto.setQuantity(hardDrive.getQuantity());
        hardDriveDto.setManufacturer(hardDrive.getManufacturer());
        hardDriveDto.setSerialNumber(hardDrive.getSerialNumber());
        hardDriveDto.setPrice(hardDrive.getPrice());
        return hardDriveDto;
    }

    public static HardDrive fromDto(HardDriveDto hardDriveDto) {
        var hardDrive = new HardDrive();
        hardDrive.setCapacityType(hardDriveDto.getCapacityType());
        hardDrive.setQuantity(hardDriveDto.getQuantity());
        hardDrive.setManufacturer(hardDriveDto.getManufacturer());
        hardDrive.setSerialNumber(hardDriveDto.getSerialNumber());
        hardDrive.setPrice(hardDriveDto.getPrice());
        return hardDrive;
    }
}

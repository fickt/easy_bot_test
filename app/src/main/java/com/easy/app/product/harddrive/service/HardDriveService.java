package com.easy.app.product.harddrive.service;

import com.easy.app.product.harddrive.model.dto.HardDriveDto;

import java.util.List;

public interface HardDriveService {
    List<HardDriveDto> getHardDrives();
    HardDriveDto getHardDriveBySerialNumber(String serialNumber);
    HardDriveDto editHardDrive(HardDriveDto hardDriveDto);
    HardDriveDto addHardDrive(HardDriveDto hardDriveDto);
}

package com.easy.app.product.harddrive.service;

import com.easy.app.product.harddrive.model.dto.HardDriveDto;
import com.easy.app.product.harddrive.model.dto.NewHardDriveRequestDto;

import java.util.List;

public interface HardDriveService {
    List<HardDriveDto> getHardDrives();
    HardDriveDto getHardDriveBySerialNumber(String serialNumber);
    HardDriveDto editHardDrive(NewHardDriveRequestDto hardDriveDto);
    HardDriveDto addHardDrive(NewHardDriveRequestDto newHardDriveDto);
}

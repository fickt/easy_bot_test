package com.easy.app.product.harddrive.controller;

import com.easy.app.product.harddrive.model.dto.HardDriveDto;
import com.easy.app.product.harddrive.service.HardDriveService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/harddrives")
@AllArgsConstructor
public class HardDriveController {
    private final HardDriveService service;

    @GetMapping
    public List<HardDriveDto> getHardDrives() {
        return service.getHardDrives();
    }

    @GetMapping("/{serialNumber}")
    public HardDriveDto getHardDriveBySerialNumber(@PathVariable String serialNumber) {
        return service.getHardDriveBySerialNumber(serialNumber);
    }

    @PatchMapping
    public HardDriveDto editHardDrive(@RequestBody HardDriveDto hardDriveDto) {
        return service.editHardDrive(hardDriveDto);
    }

    @PostMapping
    public HardDriveDto addHardDrive(@RequestBody HardDriveDto hardDriveDto) {
        return service.addHardDrive(hardDriveDto);
    }
}

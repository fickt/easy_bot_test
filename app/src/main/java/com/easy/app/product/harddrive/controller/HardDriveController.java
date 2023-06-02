package com.easy.app.product.harddrive.controller;

import com.easy.app.product.harddrive.model.dto.HardDriveDto;
import com.easy.app.product.harddrive.model.dto.NewHardDriveRequestDto;
import com.easy.app.product.harddrive.service.HardDriveService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/harddrives")
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
    public HardDriveDto editHardDrive(@RequestBody NewHardDriveRequestDto hardDriveDto) {
        return service.editHardDrive(hardDriveDto);
    }

    @PostMapping
    public HardDriveDto addHardDrive(@Valid @RequestBody NewHardDriveRequestDto newHardDriveDto) {
        return service.addHardDrive(newHardDriveDto);
    }
}

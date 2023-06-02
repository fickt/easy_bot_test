package com.easy.app.product.computer.controller;

import com.easy.app.product.computer.model.dto.ComputerDto;
import com.easy.app.product.computer.model.dto.NewComputerRequestDto;
import com.easy.app.product.computer.service.ComputerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/computers")
@AllArgsConstructor
public class ComputerController {
    private final ComputerService service;

    @GetMapping
    public List<ComputerDto> getComputers() {
        return service.getComputers();
    }

    @GetMapping("/{serialNumber}")
    public ComputerDto getComputerBySerialNumber(@PathVariable String serialNumber) {
        return service.getComputerBySerialNumber(serialNumber);
    }

    @PostMapping
    public ComputerDto addComputer(@Valid @RequestBody NewComputerRequestDto computerDto) {
        return service.addComputer(computerDto);
    }

    @PatchMapping
    public ComputerDto editComputer(@RequestBody NewComputerRequestDto computerDto) {
        return service.editComputer(computerDto);
    }
}

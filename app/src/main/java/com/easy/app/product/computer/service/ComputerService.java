package com.easy.app.product.computer.service;

import com.easy.app.product.computer.model.dto.ComputerDto;
import com.easy.app.product.computer.model.dto.NewComputerRequestDto;

import java.util.List;

public interface ComputerService {
    List<ComputerDto> getComputers();
    ComputerDto getComputerBySerialNumber(String serialNumber);
    ComputerDto addComputer(NewComputerRequestDto computerDto);
    ComputerDto editComputer(NewComputerRequestDto computerDto);
}

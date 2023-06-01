package com.easy.app.product.computer.service;

import com.easy.app.product.computer.model.dto.ComputerDto;

import java.util.List;

public interface ComputerService {
    List<ComputerDto> getComputers();
    ComputerDto getComputerBySerialNumber(String serialNumber);
    ComputerDto addComputer(ComputerDto computerDto);
    ComputerDto editComputer(ComputerDto computerDto);
}

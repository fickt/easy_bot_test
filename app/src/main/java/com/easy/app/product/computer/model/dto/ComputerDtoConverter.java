package com.easy.app.product.computer.model.dto;

import com.easy.app.product.computer.model.entity.Computer;

public class ComputerDtoConverter {
    public static Computer fromDto(ComputerDto computerDto) {
        var computer = new Computer();
        computer.setComputerType(computerDto.getComputerType());
        computer.setQuantity(computerDto.getQuantity());
        computer.setManufacturer(computerDto.getManufacturer());
        computer.setSerialNumber(computerDto.getSerialNumber());
        computer.setPrice(computerDto.getPrice());
        return computer;
    }

    public static ComputerDto toDto(Computer computer) {
        return new ComputerDto(computer.getSerialNumber(),
                computer.getManufacturer(),
                computer.getPrice(),
                computer.getQuantity(),
                computer.getComputerType());
    }
}

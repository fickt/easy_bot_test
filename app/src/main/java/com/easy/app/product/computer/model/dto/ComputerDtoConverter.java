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
        var computerDto = new ComputerDto();
        computerDto.setSerialNumber(computer.getSerialNumber());
        computerDto.setManufacturer(computer.getManufacturer());
        computerDto.setPrice(computer.getPrice());
        computerDto.setQuantity(computer.getQuantity());
        computerDto.setComputerType(computer.getComputerType());
        return computerDto;
    }

    public static ComputerDto fromNewDtoToDto(NewComputerRequestDto newComputerRequestDto) {
        var computerDto = new ComputerDto();
        computerDto.setSerialNumber(newComputerRequestDto.getSerialNumber());
        computerDto.setQuantity(newComputerRequestDto.getQuantity());
        computerDto.setPrice(newComputerRequestDto.getPrice());
        computerDto.setManufacturer(newComputerRequestDto.getManufacturer());
        return computerDto;
    }
}

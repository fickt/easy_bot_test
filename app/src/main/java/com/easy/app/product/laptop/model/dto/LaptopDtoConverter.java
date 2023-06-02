package com.easy.app.product.laptop.model.dto;

import com.easy.app.product.harddrive.model.dto.HardDriveDto;
import com.easy.app.product.harddrive.model.dto.NewHardDriveRequestDto;
import com.easy.app.product.laptop.model.entity.Laptop;

public class LaptopDtoConverter {
    public static LaptopDto toDto(Laptop laptop) {
        var laptopDto = new LaptopDto();
        laptopDto.setPrice(laptop.getPrice());
        laptopDto.setManufacturer(laptop.getManufacturer());
        laptopDto.setQuantity(laptop.getQuantity());
        laptopDto.setSerialNumber(laptop.getSerialNumber());
        laptopDto.setInchType(laptop.getInchType());
        return laptopDto;
    }

    public static Laptop fromDto(LaptopDto laptopDto) {
        var laptop = new Laptop();
        laptop.setPrice(laptopDto.getPrice());
        laptop.setManufacturer(laptopDto.getManufacturer());
        laptop.setQuantity(laptopDto.getQuantity());
        laptop.setSerialNumber(laptopDto.getSerialNumber());
        laptop.setInchType(laptopDto.getInchType());
        return laptop;
    }

    public static LaptopDto fromNewDtoToDto(NewLaptopRequestDto newLaptopDto) {
        var laptopDto = new LaptopDto();
        laptopDto.setSerialNumber(newLaptopDto.getSerialNumber());
        laptopDto.setQuantity(newLaptopDto.getQuantity());
        laptopDto.setPrice(newLaptopDto.getPrice());
        laptopDto.setManufacturer(newLaptopDto.getManufacturer());
        return laptopDto;
    }


}

package com.easy.app.product.laptop.service;

import com.easy.app.product.laptop.model.dto.LaptopDto;

import java.util.List;

public interface LaptopService {
    List<LaptopDto> getLaptops();
    LaptopDto getLaptopBySerialNumber(String serialNumber);
    LaptopDto editLaptop(LaptopDto laptopDto);
    LaptopDto addLaptop(LaptopDto laptopDto);
}

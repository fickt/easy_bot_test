package com.easy.app.product.laptop.controller;

import com.easy.app.product.laptop.model.dto.LaptopDto;
import com.easy.app.product.laptop.service.LaptopService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/laptops")
@AllArgsConstructor
public class LaptopController {

    private final LaptopService service;
    @GetMapping
    public List<LaptopDto> getLaptops() {
        return service.getLaptops();
    }

    @GetMapping("/{serialNumber}")
    public LaptopDto getLaptopBySerialNumber(@PathVariable String serialNumber) {
        return service.getLaptopBySerialNumber(serialNumber);
    }

    @PatchMapping
    public LaptopDto editLaptop(@RequestBody LaptopDto laptopDto) {
        return service.editLaptop(laptopDto);
    }

    @PostMapping
    public LaptopDto addLaptop(@RequestBody LaptopDto laptopDto) {
        return service.addLaptop(laptopDto);
    }
}

package com.easy.app.product.laptop.model.dto;

import com.easy.app.manufacturer.Manufacturer;
import com.easy.app.product.laptop.model.type.InchType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class LaptopDto {
    private String serialNumber;
    private Manufacturer manufacturer;
    private BigDecimal price;
    private Long quantity;
    private InchType inchType;
}

package com.easy.app.product.laptop.model.dto;

import com.easy.app.manufacturer.entity.Manufacturer;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class NewLaptopRequestDto {
    @NotNull(message = "serial number should not be empty")
    private String serialNumber;
    @NotNull(message = "manufacturer should not be empty")
    private Manufacturer manufacturer;
    @NotNull(message = "price should not be empty")
    private BigDecimal price;
    @NotNull(message = "quantity should not be empty")
    private Long quantity;
    @NotNull(message = "inchType should not be empty")
    private Long inchTypeId;
}

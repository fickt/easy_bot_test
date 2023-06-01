package com.easy.app.product.computer.model.dto;

import com.easy.app.manufacturer.Manufacturer;
import com.easy.app.product.computer.model.type.ComputerType;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ComputerDto {
    @NotBlank
    private String serialNumber;
    @NotBlank
    private Manufacturer manufacturer;
    @NotBlank
    private BigDecimal price;
    @NotBlank
    private Long quantity;
    @NotBlank
    private ComputerType computerType;
}

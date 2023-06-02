package com.easy.app.product.computer.model.dto;

import com.easy.app.manufacturer.entity.Manufacturer;
import com.easy.app.product.computer.model.type.ComputerType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ComputerDto {
    @NotNull(message = "serial number should not be empty")
    private String serialNumber;
    @NotNull(message = "manufacturer should not be empty")
    private Manufacturer manufacturer;
    @NotNull(message = "price should not be empty")
    private BigDecimal price;
    @NotNull(message = "quantity should not be empty")
    private Long quantity;
    @NotNull(message = "computer type should not be empty")
    private ComputerType computerType;
}

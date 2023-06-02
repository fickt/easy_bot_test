package com.easy.app.product.harddrive.model.dto;

import com.easy.app.manufacturer.entity.Manufacturer;
import com.easy.app.product.harddrive.model.type.HardDriveCapacityType;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class HardDriveDto {
    @NotNull(message = "serial number should not be empty")
    private String serialNumber;
    @NotNull(message = "manufacturer should not be empty")
    private Manufacturer manufacturer;
    @NotNull(message = "price should not be empty")
    private BigDecimal price;
    @NotNull(message = "quantity should not be empty")
    private Long quantity;
    @NotNull(message = "capacity type should not be empty")
    private HardDriveCapacityType capacityType;
}

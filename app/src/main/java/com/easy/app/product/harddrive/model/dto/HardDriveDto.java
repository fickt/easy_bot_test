package com.easy.app.product.harddrive.model.dto;

import com.easy.app.manufacturer.Manufacturer;
import com.easy.app.product.harddrive.model.type.HardDriveCapacityType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class HardDriveDto {
    private String serialNumber;
    private Manufacturer manufacturer;
    private BigDecimal price;
    private Long quantity;
    private HardDriveCapacityType capacityType;
}

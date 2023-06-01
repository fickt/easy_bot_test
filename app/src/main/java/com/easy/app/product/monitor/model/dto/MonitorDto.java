package com.easy.app.product.monitor.model.dto;

import com.easy.app.manufacturer.Manufacturer;
import com.easy.app.product.monitor.model.type.ScreenSize;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class MonitorDto {
    private String serialNumber;
    private Manufacturer manufacturer;
    private BigDecimal price;

    private Long quantity;
    private ScreenSize screenSize;
}

package com.easy.app.product.monitor.model.dto;

import com.easy.app.product.monitor.model.entity.Monitor;

public class MonitorDtoConverter {
    public static MonitorDto toDto(Monitor monitor) {
        var monitorDto = new MonitorDto();
        monitorDto.setPrice(monitor.getPrice());
        monitorDto.setManufacturer(monitor.getManufacturer());
        monitorDto.setQuantity(monitor.getQuantity());
        monitorDto.setSerialNumber(monitor.getSerialNumber());
        monitorDto.setScreenSize(monitor.getScreenSize());
        return monitorDto;
    }

    public static Monitor fromDto(MonitorDto monitorDto) {
        var monitor = new Monitor();
        monitor.setPrice(monitorDto.getPrice());
        monitor.setManufacturer(monitorDto.getManufacturer());
        monitor.setQuantity(monitorDto.getQuantity());
        monitor.setSerialNumber(monitorDto.getSerialNumber());
        monitor.setScreenSize(monitorDto.getScreenSize());
        return monitor;
    }
}

package com.easy.app.product.monitor.service;

import com.easy.app.product.monitor.model.dto.MonitorDto;

import java.util.List;

public interface MonitorService {
    List<MonitorDto> getMonitors();
    MonitorDto getMonitorBySerialNumber(String serialNumber);
    MonitorDto editMonitor(MonitorDto monitorDto);
    MonitorDto addMonitor(MonitorDto monitorDto);
}

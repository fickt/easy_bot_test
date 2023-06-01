package com.easy.app.product.monitor.controller;

import com.easy.app.product.monitor.model.dto.MonitorDto;
import com.easy.app.product.monitor.service.MonitorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/monitors")
@AllArgsConstructor
public class MonitorController {
    private final MonitorService service;
    @GetMapping
    public List<MonitorDto> getMonitors() {
        return service.getMonitors();
    }

    @GetMapping("/{serialNumber}")
    public MonitorDto getMonitorBySerialNumber(@PathVariable String serialNumber) {
        return service.getMonitorBySerialNumber(serialNumber);
    }

    @PatchMapping
    public MonitorDto editMonitor(@RequestBody MonitorDto monitorDto) {
        return service.editMonitor(monitorDto);
    }

    @PostMapping
    public MonitorDto addMonitor(@RequestBody MonitorDto monitorDto) {
        return service.addMonitor(monitorDto);
    }
}

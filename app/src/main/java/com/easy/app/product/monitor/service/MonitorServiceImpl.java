package com.easy.app.product.monitor.service;

import com.easy.app.manufacturer.service.ManufacturerService;
import com.easy.app.product.monitor.exception.MonitorAlreadyExistsException;
import com.easy.app.product.monitor.exception.MonitorNotFoundException;
import com.easy.app.product.monitor.exception.ScreenSizeNotFoundException;
import com.easy.app.product.monitor.model.dto.MonitorDto;
import com.easy.app.product.monitor.model.dto.MonitorDtoConverter;
import com.easy.app.product.monitor.model.dto.NewMonitorRequestDto;
import com.easy.app.product.monitor.model.type.ScreenSize;
import com.easy.app.product.monitor.repository.MonitorRepository;
import com.easy.app.product.monitor.repository.ScreenSizeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.easy.app.product.monitor.model.dto.MonitorDtoConverter.*;

@Service
@AllArgsConstructor
public class MonitorServiceImpl implements MonitorService {
    private static final String MSG_MONITOR_NOT_FOUND = "Monitor with serial number: %s has not been found!";
    private static final String MSG_MONITOR_ALREADY_EXISTS = "Monitor with serialNumber: %s already exists";
    private static final String MSG_SCREEN_SIZE_NOT_FOUND = "Screen size with id: %s has not been found!";

    private final MonitorRepository monitorRepository;
    private final ScreenSizeRepository screenSizeRepository;
    private final ManufacturerService manufacturerService;

    @Override
    public List<MonitorDto> getMonitors() {
        return monitorRepository.findAll()
                .stream()
                .map(MonitorDtoConverter::toDto)
                .toList();
    }

    @Override
    public MonitorDto getMonitorBySerialNumber(String serialNumber) {
        var monitor = monitorRepository.findById(serialNumber)
                .orElseThrow(() -> new MonitorNotFoundException(String.format(MSG_MONITOR_NOT_FOUND, serialNumber)));
        return toDto(monitor);
    }

    @Override
    public MonitorDto editMonitor(NewMonitorRequestDto monitorDto) {
        var monitor = monitorRepository.findById(monitorDto.getSerialNumber())
                .orElseThrow(() -> new MonitorNotFoundException(String.format(MSG_MONITOR_NOT_FOUND, monitorDto.getSerialNumber())));

        if (monitorDto.getScreenSizeId() != null) {
            var type = getScreenSizeById(monitorDto.getScreenSizeId());
            monitor.setScreenSize(type);
        }

        if (monitorDto.getPrice() != null) {
            monitor.setPrice(monitorDto.getPrice());
        }

        if (monitorDto.getQuantity() != null) {
            monitor.setQuantity(monitor.getQuantity());
        }

        if (monitorDto.getManufacturer() != null) {
            manufacturerService.handleManufacturer(monitorDto.getManufacturer());
            monitor.setManufacturer(monitorDto.getManufacturer());
        }
        return toDto(monitorRepository.save(monitor));
    }

    @Override
    public MonitorDto addMonitor(NewMonitorRequestDto newMonitorDto) {
        if (monitorRepository.existsById(newMonitorDto.getSerialNumber())) {
            throw new MonitorAlreadyExistsException(String.format(MSG_MONITOR_ALREADY_EXISTS, newMonitorDto.getSerialNumber()));
        }
        manufacturerService.handleManufacturer(newMonitorDto.getManufacturer());
        var type = getScreenSizeById(newMonitorDto.getScreenSizeId());
        var monitorDto = fromNewToDto(newMonitorDto);
        monitorDto.setScreenSize(type);
        return toDto(monitorRepository.save(fromDto(monitorDto)));
    }

    private ScreenSize getScreenSizeById(Long id) {
        return screenSizeRepository.findById(id)
                .orElseThrow(() -> new ScreenSizeNotFoundException(String.format(MSG_SCREEN_SIZE_NOT_FOUND, id)));
    }
}

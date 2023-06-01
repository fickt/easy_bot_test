package com.easy.app.product.monitor.service;

import com.easy.app.product.monitor.exception.MonitorAlreadyExistsException;
import com.easy.app.product.monitor.exception.MonitorNotFoundException;
import com.easy.app.product.monitor.model.dto.MonitorDto;
import com.easy.app.product.monitor.model.dto.MonitorDtoConverter;
import com.easy.app.product.monitor.repository.MonitorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.easy.app.product.monitor.model.dto.MonitorDtoConverter.fromDto;
import static com.easy.app.product.monitor.model.dto.MonitorDtoConverter.toDto;

@Service
@AllArgsConstructor
public class MonitorServiceImpl implements MonitorService {
    private static final String MSG_MONITOR_NOT_FOUND = "Monitor with serial number: \"%s\" has not been found!";
    private static final String MSG_MONITOR_ALREADY_EXISTS = "Monitor with serialNumber: \"%s\" already exists";

    private final MonitorRepository repository;

    @Override
    public List<MonitorDto> getMonitors() {
        return repository.findAll()
                .stream()
                .map(MonitorDtoConverter::toDto)
                .toList();
    }

    @Override
    public MonitorDto getMonitorBySerialNumber(String serialNumber) {
        var monitor = repository.findById(serialNumber)
                .orElseThrow(() -> {
                    throw new MonitorNotFoundException(String.format(MSG_MONITOR_NOT_FOUND, serialNumber));
                });
        return toDto(monitor);
    }

    @Override
    public MonitorDto editMonitor(MonitorDto monitorDto) {
        var monitor = repository.findById(monitorDto.getSerialNumber())
                .orElseThrow(() -> {
                    throw new MonitorNotFoundException(String.format(MSG_MONITOR_NOT_FOUND, monitorDto.getSerialNumber()));
                });

        if (monitorDto.getScreenSize() != null) {
            monitor.setScreenSize(monitorDto.getScreenSize());
        }

        if (monitorDto.getPrice() != null) {
            monitor.setPrice(monitorDto.getPrice());
        }

        if (monitorDto.getQuantity() != null) {
            monitor.setQuantity(monitor.getQuantity());
        }

        if (monitorDto.getManufacturer() != null) {
            monitor.setManufacturer(monitorDto.getManufacturer());
        }
        return toDto(repository.save(monitor));
    }

    @Override
    public MonitorDto addMonitor(MonitorDto monitorDto) {
        if (repository.existsById(monitorDto.getSerialNumber())) {
            throw new MonitorAlreadyExistsException(String.format(MSG_MONITOR_ALREADY_EXISTS, monitorDto.getSerialNumber()));
        }

        var monitor = fromDto(monitorDto);
        return toDto(repository.save(monitor));
    }
}

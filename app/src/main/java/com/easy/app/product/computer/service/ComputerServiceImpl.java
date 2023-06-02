package com.easy.app.product.computer.service;

import com.easy.app.manufacturer.service.ManufacturerService;
import com.easy.app.product.computer.exception.ComputerAlreadyExistsException;
import com.easy.app.product.computer.exception.ComputerNotFoundException;
import com.easy.app.product.computer.exception.ComputerTypeNotFoundException;
import com.easy.app.product.computer.model.dto.ComputerDto;
import com.easy.app.product.computer.model.dto.ComputerDtoConverter;
import com.easy.app.product.computer.model.dto.NewComputerRequestDto;
import com.easy.app.product.computer.model.entity.Computer;
import com.easy.app.product.computer.model.type.ComputerType;
import com.easy.app.product.computer.repository.ComputerRepository;
import com.easy.app.product.computer.repository.ComputerTypeRepository;
import com.easy.app.product.monitor.exception.MonitorAlreadyExistsException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.easy.app.product.computer.model.dto.ComputerDtoConverter.*;

@Service
@AllArgsConstructor
public class ComputerServiceImpl implements ComputerService {
    private static final String MSG_COMPUTER_NOT_FOUND = "Computer with serial number: %s has not been found!";
    private static final String MSG_COMPUTER_ALREADY_EXISTS = "Computer with serial number: %s already exists!";
    private static final String MSG_COMPUTER_TYPE_NOT_FOUND = "Computer type with id: %s has not been found!";

    private final ComputerRepository computerRepository;
    private final ComputerTypeRepository computerTypeRepository;
    private final ManufacturerService manufacturerService;

    @Override
    public List<ComputerDto> getComputers() {
        return computerRepository.findAll()
                .stream()
                .map(ComputerDtoConverter::toDto)
                .toList();
    }

    @Override
    public ComputerDto getComputerBySerialNumber(String serialNumber) {
        var computer = computerRepository.findById(serialNumber)
                .orElseThrow(() -> new ComputerNotFoundException(String.format(MSG_COMPUTER_NOT_FOUND, serialNumber)));

        return toDto(computer);
    }

    @Override
    public ComputerDto addComputer(NewComputerRequestDto newComputerDto) {
        if (computerRepository.existsById(newComputerDto.getSerialNumber())) {
            throw new ComputerAlreadyExistsException(String.format(MSG_COMPUTER_ALREADY_EXISTS, newComputerDto.getSerialNumber()));
        }
        manufacturerService.handleManufacturer(newComputerDto.getManufacturer());

        var type = getComputerTypeById(newComputerDto.getComputerTypeId());

        var computerDto = fromNewDtoToDto(newComputerDto);
        computerDto.setComputerType(type);
        var computer = fromDto(computerDto);
        return toDto(computerRepository.save(computer));
    }

    @Override
    public ComputerDto editComputer(NewComputerRequestDto computerDto) {
        var computer = computerRepository.findById(computerDto.getSerialNumber())
                .orElseThrow(() -> new ComputerNotFoundException(String.format(MSG_COMPUTER_NOT_FOUND, computerDto.getSerialNumber())));

        if (computerDto.getComputerTypeId() != null) {
            var type = getComputerTypeById(computerDto.getComputerTypeId());
            computer.setComputerType(type);
        }

        if (computerDto.getPrice() != null) {
            computer.setPrice(computerDto.getPrice());
        }

        if (computerDto.getQuantity() != null) {
            computer.setQuantity(computerDto.getQuantity());
        }

        if (computerDto.getManufacturer() != null) {
            manufacturerService.handleManufacturer(computerDto.getManufacturer());
            computer.setManufacturer(computerDto.getManufacturer());
        }
        return toDto(computerRepository.save(computer));
    }

    private ComputerType getComputerTypeById(Long id) {
        return computerTypeRepository.findById(id)
                .orElseThrow(() -> new ComputerTypeNotFoundException(
                        String.format(MSG_COMPUTER_TYPE_NOT_FOUND, id)
                ));
    }
}

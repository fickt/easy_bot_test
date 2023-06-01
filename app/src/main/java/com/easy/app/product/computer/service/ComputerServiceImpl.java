package com.easy.app.product.computer.service;

import com.easy.app.product.computer.exception.ComputerNotFoundException;
import com.easy.app.product.computer.model.dto.ComputerDto;
import com.easy.app.product.computer.model.dto.ComputerDtoConverter;
import com.easy.app.product.computer.repository.ComputerRepository;
import com.easy.app.product.monitor.exception.MonitorAlreadyExistsException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.easy.app.product.computer.model.dto.ComputerDtoConverter.fromDto;
import static com.easy.app.product.computer.model.dto.ComputerDtoConverter.toDto;

@Service
@AllArgsConstructor
public class ComputerServiceImpl implements ComputerService {
    private static final String MSG_COMPUTER_NOT_FOUND = "Computer with serial number: \"%s\" has not been found!";
    private static final String MSG_COMPUTER_ALREADY_EXISTS = "Computer with serial number: \"%s\" already exists!";
    private final ComputerRepository computerRepository;

    @Override
    public List<ComputerDto> getComputers() {
        return computerRepository.findAll()
                .stream()
                .peek(val -> System.out.println(val.getComputerType().toString() + "_____COMPUTERTYPE"))
                .map(ComputerDtoConverter::toDto)
                .toList();
    }

    @Override
    public ComputerDto getComputerBySerialNumber(final String serialNumber) {
        var computer = computerRepository.findById(serialNumber)
                .orElseThrow(() -> {
                    throw new ComputerNotFoundException(String.format(MSG_COMPUTER_NOT_FOUND, serialNumber));
                });

        return toDto(computer);
    }

    @Override
    public ComputerDto addComputer(ComputerDto computerDto) { //TODO захреначить валидацию
        if (computerRepository.existsById(computerDto.getSerialNumber())) {
            throw new MonitorAlreadyExistsException(String.format(MSG_COMPUTER_ALREADY_EXISTS, computerDto.getSerialNumber()));
        }

        var computer = fromDto(computerDto);
        return toDto(computerRepository.save(computer));
    }

    @Override
    public ComputerDto editComputer(ComputerDto computerDto) {
        var computer = computerRepository.findById(computerDto.getSerialNumber())
                .orElseThrow(() -> {
                    throw new ComputerNotFoundException(String.format(MSG_COMPUTER_NOT_FOUND, computerDto.getSerialNumber()));
                });
        if (computerDto.getComputerType() != null) {
            computer.setComputerType(computerDto.getComputerType());
        }

        if (computerDto.getPrice() != null) {
            computer.setPrice(computerDto.getPrice());
        }

        if (computerDto.getQuantity() != null) {
            computer.setQuantity(computerDto.getQuantity());
        }

        if (computerDto.getSerialNumber() != null) {
            computer.setSerialNumber(computerDto.getSerialNumber());
        }

        if (computerDto.getManufacturer() != null) {
            computer.setManufacturer(computerDto.getManufacturer());
        }
        return toDto(computerRepository.save(computer));
    }
}

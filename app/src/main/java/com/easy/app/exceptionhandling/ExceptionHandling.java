package com.easy.app.exceptionhandling;

import com.easy.app.product.computer.exception.ComputerAlreadyExistsException;
import com.easy.app.product.computer.exception.ComputerNotFoundException;
import com.easy.app.product.harddrive.exception.HardDriveAlreadyExists;
import com.easy.app.product.harddrive.exception.HardDriveNotFound;
import com.easy.app.product.laptop.exception.LaptopAlreadyExists;
import com.easy.app.product.laptop.exception.LaptopNotFoundException;
import com.easy.app.product.monitor.exception.MonitorAlreadyExistsException;
import com.easy.app.product.monitor.exception.MonitorNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionHandling {
    @ExceptionHandler({
            ComputerNotFoundException.class,
            MonitorNotFoundException.class,
            HardDriveNotFound.class,
            LaptopNotFoundException.class
    })
    public ResponseEntity<ErrorResponse> handleNotFoundException(Exception e) {
        var response = new ErrorResponse(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                e.getMessage()
        );

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({
            ComputerAlreadyExistsException.class,
            MonitorAlreadyExistsException.class,
            HardDriveAlreadyExists.class,
            LaptopAlreadyExists.class
    })
    public ResponseEntity<ErrorResponse> handleAlreadyExistsException(Exception e) {
        var response = new ErrorResponse(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                e.getMessage()
        );

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        var response = new ErrorResponse(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                e.getBindingResult().getAllErrors().get(0).getDefaultMessage()
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}

package com.easy.app.product.computer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ComputerAlreadyExistsException extends RuntimeException {
    public ComputerAlreadyExistsException(String message) {
        super(message);
    }
}

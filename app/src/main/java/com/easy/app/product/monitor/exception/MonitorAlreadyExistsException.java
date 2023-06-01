package com.easy.app.product.monitor.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class MonitorAlreadyExistsException extends RuntimeException {
    public MonitorAlreadyExistsException(String message) {
        super(message);
    }
}

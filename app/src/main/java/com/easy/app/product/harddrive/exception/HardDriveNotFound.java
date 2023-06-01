package com.easy.app.product.harddrive.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class HardDriveNotFound extends RuntimeException {
    public HardDriveNotFound(String message) {
        super(message);
    }
}

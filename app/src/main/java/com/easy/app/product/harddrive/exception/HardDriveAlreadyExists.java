package com.easy.app.product.harddrive.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class HardDriveAlreadyExists extends RuntimeException {
    public HardDriveAlreadyExists(String message) {
        super(message);
    }
}

package com.easy.app.product.laptop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class LaptopNotFoundException extends RuntimeException {
    public LaptopNotFoundException(String message) {
        super(message);
    }
}

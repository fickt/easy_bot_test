package com.easy.app.product.laptop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class LaptopAlreadyExists extends RuntimeException {
    public LaptopAlreadyExists(String message) {
        super(message);
    }
}

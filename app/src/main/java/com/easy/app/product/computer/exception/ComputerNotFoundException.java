package com.easy.app.product.computer.exception;


public class ComputerNotFoundException extends RuntimeException {
    public ComputerNotFoundException(String message) {
        super(message);
    }
}

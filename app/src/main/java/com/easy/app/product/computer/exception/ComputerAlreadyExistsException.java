package com.easy.app.product.computer.exception;


public class ComputerAlreadyExistsException extends RuntimeException {
    public ComputerAlreadyExistsException(String message) {
        super(message);
    }
}

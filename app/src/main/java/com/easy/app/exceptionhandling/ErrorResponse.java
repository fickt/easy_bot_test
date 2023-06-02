package com.easy.app.exceptionhandling;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorResponse {
    @JsonFormat(pattern="HH:mm:ss yyyy-MM-dd")
    private final LocalDateTime timestamp;
    private final Integer code;
    private String message;
}

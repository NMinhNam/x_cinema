package com.application.x_cinema.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class ApiResponse<T> {
    private boolean success;

    private String message;

    private String code;

    private T data;

    private LocalDateTime timestamp;

    public ApiResponse(boolean success, String message, String code, T data) {
        this.success = success;
        this.message = message;
        this.code = code;
        this.data = data;
        this.timestamp = LocalDateTime.now();
    }
}

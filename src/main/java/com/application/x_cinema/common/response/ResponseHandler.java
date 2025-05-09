package com.application.x_cinema.common.response;

import com.application.x_cinema.common.enums.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {

    public static <T> ResponseEntity<ApiResponse<T>> success(T data) {
        return ResponseEntity.ok(new ApiResponse<>(true, "Success", null, data));
    }

    public static <T> ResponseEntity<ApiResponse<T>> success(String message, T data) {
        return ResponseEntity.ok(new ApiResponse<>(true, message, null, data));
    }

    public static ResponseEntity<ApiResponse<Object>> error(ErrorCode errorCode) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse<>(false, errorCode.getMessage(), errorCode.getCode(), null));
    }

    public static ResponseEntity<ApiResponse<Object>> error(ErrorCode errorCode, HttpStatus status, String message) {
        return ResponseEntity.status(status).body(new ApiResponse<>(false, errorCode.getMessage(), errorCode.getCode(), message));
    }

    public static ResponseEntity<ApiResponse<Object>> error(String customMessage, ErrorCode errorCode, HttpStatus status) {
        return ResponseEntity.status(status).body(new ApiResponse<>(false, customMessage, errorCode.getCode(), null));
    }
}

package com.application.x_cinema.common.enums;

import lombok.Getter;

@Getter
public enum ErrorCode {
    INTERNAL_ERROR("5000", "Lỗi hệ thống"),
    USER_NOT_FOUND("5001", "Không tìm thấy người dụng"),
    VOUCHER_NOT_FOUND("5002", "Không tìm thấy VOUCHER"),
    ;

    private final String code;
    
    private final String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}

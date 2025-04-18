package com.application.x_cinema.common.enums;

import lombok.Getter;

@Getter
public enum ErrorCode {
    INTERNAL_ERROR("5000", "Lỗi hệ thống"),
    NOT_FOUND("404", "Không tìm thấy dữ liệu"),
    BAD_REQUEST("400", "Yêu cầu không hợp lệ"),
    ;

    private final String code;
    
    private final String message;

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}

package com.application.x_cinema.common.enums;

import lombok.Getter;

@Getter
public enum ErrorCode {
    INTERNAL_ERROR("5000", "Lỗi hệ thống"),
    MOVIE_NOT_EXISTS("2000", "Phim không tồn tại!"),
    ;

    private final String code;
    
    private final String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}

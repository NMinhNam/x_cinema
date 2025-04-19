package com.application.x_cinema.common.exception;

import com.application.x_cinema.common.enums.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AppException extends RuntimeException{
    private ErrorCode errorCode;
}

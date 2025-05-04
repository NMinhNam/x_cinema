package com.application.x_cinema.seat.dto.request;

import com.application.x_cinema.common.validator.ValidEnum;
import com.application.x_cinema.seat.enums.SeatStatus;
import com.application.x_cinema.seat.enums.SeatType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class SeatRequestDTO {
    private UUID roomId;

    @Size(max = 20, message = "Position must not exceed 20 characters")
    private String position;

    @Size(max = 5, message = "Row alphabet must not exceed 5 characters")
    private String rowAlphabet;

    @Positive(message = "Column number must be a positive number")
    private Integer columnNumber;

    @NotNull(message = "Seat type is required")
    @ValidEnum(enumClass = SeatType.class, message = "Invalid seat type")
    private SeatType seatType;

    @NotNull(message = "Seat status is required")
    @ValidEnum(enumClass = SeatStatus.class, message = "Invalid seat status")
    private SeatStatus seatStatus;

    @PositiveOrZero(message = "Surcharge must be a positive number or zero")
    private Integer surcharge;

}

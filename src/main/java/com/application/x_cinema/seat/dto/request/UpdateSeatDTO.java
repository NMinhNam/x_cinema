package com.application.x_cinema.seat.dto.request;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UpdateSeatDTO {

    private UUID roomId;

    @Size(max = 20, message = "Position must be less than or equal to 20 characters")
    private String position;

    @Size(max = 5, message = "Row alphabet must be less than or equal to 5 characters")
    private String rowAlphabet;

    @Positive(message = "Column number must be a positive number")
    private Integer columnNumber;

    @Size(max = 20, message = "Seat type must be less than or equal to 20 characters")
    private String seatType;

    @Size(max = 20, message = "Seat status must be less than or equal to 20 characters")
    private String seatStatus;

    @PositiveOrZero(message = "Surcharge must be a positive number or zero")
    private Integer surcharge;
}

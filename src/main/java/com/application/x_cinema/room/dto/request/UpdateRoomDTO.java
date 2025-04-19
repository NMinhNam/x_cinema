package com.application.x_cinema.room.dto.request;

import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UpdateRoomDTO {

    private UUID cinemaId;

    @Size(max = 255, message = "Room name must not exceed 255 characters")
    private String roomName;

    @Size(max = 20, message = "Room type must not exceed 20 characters")
    private String roomType;

    @PositiveOrZero(message = "Total seat must be a positive number or zero")
    private Integer totalSeat;

    @PositiveOrZero(message = "Surcharge must be a positive number or zero")
    private Integer surcharge;
}

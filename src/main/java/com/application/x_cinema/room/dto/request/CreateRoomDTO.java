package com.application.x_cinema.room.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CreateRoomDTO {

    @NotNull(message = "Cinema ID is required")
    private UUID cinemaId;

    @NotBlank(message = "Room name is required")
    @Size(max = 255, message = "Room name must not exceed 255 characters")
    private String roomName;

    @Size(max = 20, message = "Room type must not exceed 20 characters")
    private String roomType;

    @NotNull(message = "Total seat is required")
    private Integer totalSeat;

    @PositiveOrZero(message = "Surcharge must be a positive number or zero")
    private Integer surcharge;
}

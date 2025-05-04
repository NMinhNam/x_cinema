package com.application.x_cinema.seat.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SeatStatus {
    AVAILABLE("Available"),
    BOOKED("Booked"),
    BROKEN("Broken"),
    LOCKED("Locked");

    private final String displayName;
}

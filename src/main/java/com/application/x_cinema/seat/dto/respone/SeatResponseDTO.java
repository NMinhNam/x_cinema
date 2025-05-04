package com.application.x_cinema.seat.dto.respone;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SeatResponseDTO {
    private UUID id;

    private String roomId;

    private String position;

    private String rowAlphabet;

    private Integer columnNumber;

    private String seatType;

    private String seatStatus;

    private Integer surcharge;

}

package com.application.x_cinema.room.dto.respone;

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
public class RoomResponseDTO {

    private UUID id;

    private String cinemaId;

    private String roomName;

    private String roomType;

    private Integer totalSeat;

    private Integer surcharge;


}

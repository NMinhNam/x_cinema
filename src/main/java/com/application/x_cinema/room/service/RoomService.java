package com.application.x_cinema.room.service;

import com.application.x_cinema.cinema.dto.request.UpdateCinemaDTO;
import com.application.x_cinema.cinema.dto.response.CinemaResponseDTO;
import com.application.x_cinema.common.service.BaseService;
import com.application.x_cinema.room.dto.request.RoomRequestDTO;
import com.application.x_cinema.room.dto.request.UpdateRoomDTO;
import com.application.x_cinema.room.dto.respone.RoomResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface RoomService extends BaseService<RoomRequestDTO, RoomResponseDTO, UUID> {
    Page<RoomResponseDTO> getByCinemaId(UUID cinemaId, Pageable pageable);
}

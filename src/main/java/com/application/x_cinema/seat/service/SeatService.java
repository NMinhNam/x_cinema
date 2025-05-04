package com.application.x_cinema.seat.service;

import com.application.x_cinema.common.service.BaseService;
import com.application.x_cinema.seat.dto.request.SeatRequestDTO;
import com.application.x_cinema.seat.dto.respone.SeatResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface SeatService extends BaseService <SeatRequestDTO, SeatResponseDTO, UUID> {
    Page<SeatResponseDTO> getByRoomId(UUID roomId, Pageable pageable);
}

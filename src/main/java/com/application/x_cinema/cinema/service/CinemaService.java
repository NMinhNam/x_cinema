package com.application.x_cinema.cinema.service;

import com.application.x_cinema.cinema.dto.request.CinemaRequestDTO;
import com.application.x_cinema.cinema.dto.request.CreateCinemaDTO;
import com.application.x_cinema.cinema.dto.request.UpdateCinemaDTO;
import com.application.x_cinema.cinema.dto.response.CinemaResponseDTO;
import com.application.x_cinema.common.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface CinemaService extends BaseService<CinemaRequestDTO, CinemaResponseDTO, UUID> {

    Page<CinemaResponseDTO> findByCity(String city, Pageable pageable);

    Page<CinemaResponseDTO> findByName(String name, Pageable pageable);

    Page<CinemaResponseDTO> findByCityAndName(String city, String name, Pageable pageable);

}

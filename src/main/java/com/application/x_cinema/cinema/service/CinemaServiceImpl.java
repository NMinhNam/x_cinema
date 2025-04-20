package com.application.x_cinema.cinema.service;

import com.application.x_cinema.cinema.dto.request.CinemaRequestDTO;
import com.application.x_cinema.cinema.dto.request.UpdateCinemaDTO;
import com.application.x_cinema.cinema.dto.response.CinemaResponseDTO;
import com.application.x_cinema.cinema.entity.Cinema;
import com.application.x_cinema.cinema.mapper.CinemaMapper;
import com.application.x_cinema.cinema.repository.CinemaRepository;
import com.application.x_cinema.common.enums.ErrorCode;
import com.application.x_cinema.common.exception.AppException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CinemaServiceImpl implements CinemaService {

    private final CinemaRepository cinemaRepository;

    private final CinemaMapper cinemaMapper;


    @Override
    public Page<CinemaResponseDTO> findByCity(String city, Pageable pageable) {
        // 1. Get all Cinema by city from DB
        Page<Cinema> cinemaPage = cinemaRepository.findByCityContainingIgnoreCase(city, pageable);
        // 2. Map from Cinema entity to CinemaResponseDTO
        return cinemaPage.map(cinemaMapper::toResponse);
    }

    @Override
    public Page<CinemaResponseDTO> findByName(String name, Pageable pageable) {
        // 1. Get all Cinema by name from DB
        Page<Cinema> cinemaPage = cinemaRepository.findByNameContainingIgnoreCase(name, pageable);
        // 2. Map from Cinema entity to CinemaResponseDTO
        return cinemaPage.map(cinemaMapper::toResponse);
    }

    @Override
    public Page<CinemaResponseDTO> findByCityAndName(String city, String name, Pageable pageable) {
        // 1. Get all Cinema by city and name from DB
        Page<Cinema> cinemaPage = cinemaRepository.findByCityAndNameContainingIgnoreCase(city, name, pageable);
        // 2. Map from Cinema entity to CinemaResponseDTO
        return cinemaPage.map(cinemaMapper::toResponse);
    }

    @Override
    @Transactional
    public CinemaResponseDTO create(CinemaRequestDTO dto) {
        // 1. Map from CinemaRequestDTO to Cinema entity
        Cinema cinema = cinemaMapper.toEntity(dto);
        // 2. Save Cinema entity to DB
        cinema = cinemaRepository.save(cinema);
        // 3. Map from Cinema entity to CinemaResponseDTO
        return cinemaMapper.toResponse(cinema);
    }

    @Override
    @Transactional
    public CinemaResponseDTO update(UUID id, CinemaRequestDTO dto) {
        // 1. Find Cinema by ID
        Cinema cinema = cinemaRepository.findById(id)
                                        .orElseThrow(() -> new AppException(ErrorCode.CINEMA_NOT_FOUND));
        // 2. Update Cinema from CinemaRequestDTO
        cinemaMapper.updateEntityFromDTO(dto, cinema);
        // 3. Save updated Cinema entity to DB
        cinema = cinemaRepository.save(cinema);
        // 4. Map from Cinema entity to CinemaResponseDTO
        return cinemaMapper.toResponse(cinema);
    }

    @Override
    public CinemaResponseDTO getById(UUID id) {
        // 1. Find Cinema by ID
        Cinema cinema = cinemaRepository.findById(id)
                                        .orElseThrow(() -> new AppException(ErrorCode.CINEMA_NOT_FOUND));
        // 2. Map from Cinema entity to CinemaResponseDTO
        return cinemaMapper.toResponse(cinema);
    }

    @Override
    public Page<CinemaResponseDTO> getAll(Pageable pageable) {
        // 1. Get all Cinema entities from DB
        Page<Cinema> cinemaPage = cinemaRepository.findAll(pageable);
        // 2. Map from Cinema entity to CinemaResponseDTO
        return cinemaPage.map(cinemaMapper::toResponse);
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        // 1. Find Cinema by ID
        Cinema cinema = cinemaRepository.findById(id)
                                        .orElseThrow(() -> new AppException(ErrorCode.CINEMA_NOT_FOUND));
        // 2. Delete Cinema entity from DB
        cinemaRepository.delete(cinema);
    }
}

package com.application.x_cinema.cinema.service;

import com.application.x_cinema.cinema.dto.request.CinemaRequestDTO;
import com.application.x_cinema.cinema.dto.request.UpdateCinemaDTO;
import com.application.x_cinema.cinema.dto.response.CinemaResponseDTO;
import com.application.x_cinema.cinema.entity.Cinema;
import com.application.x_cinema.cinema.mapper.CinemaMapper;
import com.application.x_cinema.cinema.repository.CinemaRepository;
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
        return cinemaRepository.findByCityContainingIgnoreCase(city, pageable)
                .map(cinemaMapper::toResponse);
    }

    @Override
    public Page<CinemaResponseDTO> findByName(String name, Pageable pageable) {
        return cinemaRepository.findByNameContainingIgnoreCase(name, pageable)
                .map(cinemaMapper::toResponse);
    }

    @Override
    public Page<CinemaResponseDTO> findByCityAndName(String city, String name, Pageable pageable) {
        return cinemaRepository.findByCityAndNameContainingIgnoreCase(city, name, pageable)
                .map(cinemaMapper::toResponse);
    }

    @Override
    public CinemaResponseDTO updateFromDTO(UUID id, UpdateCinemaDTO dto) {
        Cinema cinema = cinemaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cinema not found"));
        cinemaMapper.updateEntityFromDTO(dto, cinema);
        cinemaRepository.save(cinema);
        return cinemaMapper.toResponse(cinema);
    }

    @Override
    @Transactional
    public CinemaResponseDTO create(CinemaRequestDTO dto) {
        Cinema cinema = cinemaMapper.toEntity(dto);
        cinemaRepository.save(cinema);
        return cinemaMapper.toResponse(cinema);
    }

    @Override
    @Transactional
    public CinemaResponseDTO update(UUID id, CinemaRequestDTO dto) {
//        Cinema cinema = cinemaRepository.findById(id)
//                                        .orElseThrow(() -> new EntityNotFoundException("Cinema not found"));
//        cinemaMapper.toRequest(dto);
//        cinemaRepository.save(cinema);
//        return cinemaMapper.toResponse(cinema);
        throw new UnsupportedOperationException("Use updateFromDTO instead");
    }

    @Override
    public CinemaResponseDTO getById(UUID id) {
        return cinemaRepository.findById(id)
                .map(cinemaMapper::toResponse)
                .orElseThrow(() -> new EntityNotFoundException("Cinema not found"));
    }

    @Override
    public Page<CinemaResponseDTO> getAll(Pageable pageable) {
        Page<Cinema> cinemaPage = cinemaRepository.findAll(pageable);
        return cinemaPage.map(cinemaMapper::toResponse);
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        cinemaRepository.deleteById(id);
    }

}

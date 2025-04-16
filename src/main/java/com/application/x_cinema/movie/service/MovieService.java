package com.application.x_cinema.movie.service;

import com.application.x_cinema.common.service.BaseService;
import com.application.x_cinema.movie.dto.request.MovieRequestDTO;
import com.application.x_cinema.movie.dto.response.MovieResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface MovieService extends BaseService<MovieRequestDTO, MovieResponseDTO, UUID> {
    Page<MovieResponseDTO> findById(UUID movieId, Pageable pageable);
}

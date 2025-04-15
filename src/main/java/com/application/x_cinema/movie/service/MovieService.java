package com.application.x_cinema.movie.service;

import com.application.x_cinema.common.service.BaseService;
import com.application.x_cinema.movie.dto.request.MovieRequestDTO;
import com.application.x_cinema.movie.dto.response.MovieResponseDTO;

import java.util.UUID;

public interface MovieService extends BaseService<MovieRequestDTO, MovieResponseDTO, UUID> {
}

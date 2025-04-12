package com.application.x_cinema.movie.controller;

import com.application.x_cinema.common.controller.BaseController;
import com.application.x_cinema.common.response.ApiResponse;
import com.application.x_cinema.movie.dto.request.CreateMovieDTO;
import com.application.x_cinema.movie.dto.request.UpdateMovieDTO;
import com.application.x_cinema.movie.dto.response.MovieResponseDTO;
import com.application.x_cinema.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/movies")
@RequiredArgsConstructor
public class MovieController extends BaseController<CreateMovieDTO, UpdateMovieDTO, MovieResponseDTO, UUID> {

    private final MovieService movieService;

    @Override
    public ResponseEntity<ApiResponse<MovieResponseDTO>> create(CreateMovieDTO dto) {
        return null;
    }

    @Override
    public ResponseEntity<ApiResponse<MovieResponseDTO>> getById(UUID uuid) {
        return null;
    }

    @Override
    public ResponseEntity<ApiResponse<Page<MovieResponseDTO>>> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public ResponseEntity<ApiResponse<MovieResponseDTO>> update(UUID uuid, UpdateMovieDTO dto) {
        return null;
    }

    @Override
    public ResponseEntity<ApiResponse<Void>> delete(UUID uuid) {
        return null;
    }
}

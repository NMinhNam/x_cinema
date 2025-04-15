package com.application.x_cinema.movie.controller;

import com.application.x_cinema.common.controller.BaseController;
import com.application.x_cinema.common.response.ApiResponse;
import com.application.x_cinema.movie.dto.request.CreateMovieDTO;
import com.application.x_cinema.movie.dto.request.UpdateMovieDTO;
import com.application.x_cinema.movie.dto.response.MovieResponseDTO;
import com.application.x_cinema.movie.service.MovieService;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<ApiResponse<Page<MovieResponseDTO>>> getAll() {
        return null;
    }

    @GetMapping("/list")
    public ResponseEntity<Page<MovieResponseDTO>> getAll(@RequestParam(defaultValue = "0") @Min(value = 0, message = "Page must be greater than or equal to 0") int page,
                                                         @RequestParam(defaultValue = "10") @Min(value = 1, message = "Size must be greater than 0") int size) {
        // Tạo Pageable
        Pageable pageable = PageRequest.of(page, size);

        // Gọi service
        Page<MovieResponseDTO> moviePage = movieService.getAll(pageable);

        return ResponseEntity.ok(moviePage);
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

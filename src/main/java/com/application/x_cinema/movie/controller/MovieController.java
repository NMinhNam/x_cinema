package com.application.x_cinema.movie.controller;

import com.application.x_cinema.common.constants.ApiConstants;
import com.application.x_cinema.common.controller.BaseController;
import com.application.x_cinema.common.response.ApiResponse;
import com.application.x_cinema.common.response.ResponseHandler;
import com.application.x_cinema.movie.dto.request.CreateMovieDTO;
import com.application.x_cinema.movie.dto.request.UpdateMovieDTO;
import com.application.x_cinema.movie.dto.response.MovieResponseDTO;
import com.application.x_cinema.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(ApiConstants.Movie.BASE)
@RequiredArgsConstructor
public class MovieController extends BaseController<CreateMovieDTO, UpdateMovieDTO, MovieResponseDTO, UUID> {

    private final MovieService movieService;

    @Override
    public ResponseEntity<ApiResponse<MovieResponseDTO>> create(CreateMovieDTO dto) {
        return null;
    }

    @Override
    public ResponseEntity<ApiResponse<MovieResponseDTO>> getById(UUID uuid) {
        // Gọi service
        MovieResponseDTO movieResponse = movieService.getById(uuid);

        return ResponseHandler.success(movieResponse);
    }


    @Override
    public ResponseEntity<ApiResponse<Page<MovieResponseDTO>>> getAll(@RequestParam(defaultValue = "0") int page,
                                                                      @RequestParam(defaultValue = "10") int size,
                                                                      @RequestParam(defaultValue = "id") String sort,
                                                                      @RequestParam(defaultValue = "desc") String direction) {
        // Tạo Sort
        Sort.Direction sortDirection = direction.equalsIgnoreCase("asc")
                ? Sort.Direction.ASC
                : Sort.Direction.DESC;
        Sort sortBy = Sort.by(sortDirection, sort);

        // Tạo Pageable
        Pageable pageable = PageRequest.of(page, size, sortBy);

        // Gọi service
        Page<MovieResponseDTO> moviePage = movieService.getAll(pageable);

        return ResponseHandler.success(moviePage);
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

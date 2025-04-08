package com.application.x_cinema.movie.controller;

import com.application.x_cinema.common.controller.BaseController;
import com.application.x_cinema.common.response.ApiResponse;
import com.application.x_cinema.common.response.ResponseHandler;
import com.application.x_cinema.movie.dto.response.MovieResponse;
import com.application.x_cinema.movie.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController extends BaseController<MovieResponse, UUID> {

    public MovieController(MovieService service) {
        super(service);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<MovieResponse>> create(MovieResponse dto) {
        return ResponseHandler.success(service.create(dto));
    }

    public ResponseEntity<ApiResponse<MovieResponse>> getById(UUID uuid) {
        return null;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<MovieResponse>>> getAll() {
        return ResponseHandler.success(service.getAll());
    }

    public ResponseEntity<ApiResponse<MovieResponse>> update(UUID uuid, MovieResponse dto) {
        return null;
    }

    public ResponseEntity<ApiResponse<Void>> delete(UUID uuid) {
        return null;
    }
}

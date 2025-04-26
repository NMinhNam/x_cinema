package com.application.x_cinema.genre.controller;

import com.application.x_cinema.common.constants.ApiConstants;
import com.application.x_cinema.common.controller.BaseController;
import com.application.x_cinema.common.request.PagingAndSortingRequest;
import com.application.x_cinema.common.response.ApiResponse;
import com.application.x_cinema.genre.dto.request.CreateGenreDTO;
import com.application.x_cinema.genre.dto.request.UpdateGenreDTO;
import com.application.x_cinema.genre.dto.response.GenreResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(ApiConstants.GENRE)
public class GenreController extends BaseController<CreateGenreDTO, UpdateGenreDTO, GenreResponseDTO, UUID> {
    @Override
    public ResponseEntity<ApiResponse<GenreResponseDTO>> create(CreateGenreDTO dto) {
        return null;
    }

    @Override
    public ResponseEntity<ApiResponse<GenreResponseDTO>> getById(UUID uuid) {
        return null;
    }

    @Override
    public ResponseEntity<ApiResponse<Page<GenreResponseDTO>>> getAll(@ModelAttribute PagingAndSortingRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<ApiResponse<GenreResponseDTO>> update(UUID uuid, UpdateGenreDTO dto) {
        return null;
    }

    @Override
    public ResponseEntity<ApiResponse<Void>> delete(UUID uuid) {
        return null;
    }
}

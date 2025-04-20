package com.application.x_cinema.cinema.controller;

import com.application.x_cinema.cinema.dto.request.CinemaRequestDTO;
import com.application.x_cinema.cinema.dto.request.CreateCinemaDTO;
import com.application.x_cinema.cinema.dto.request.UpdateCinemaDTO;
import com.application.x_cinema.cinema.dto.response.CinemaResponseDTO;
import com.application.x_cinema.cinema.mapper.CinemaMapper;
import com.application.x_cinema.cinema.service.CinemaService;
import com.application.x_cinema.common.constants.ApiConstants;
import com.application.x_cinema.common.controller.BaseController;
import com.application.x_cinema.common.request.PagingAndSortingRequest;
import com.application.x_cinema.common.response.ApiResponse;
import com.application.x_cinema.common.response.ResponseHandler;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(ApiConstants.Cinema.BASE)
@RequiredArgsConstructor
public class CinemaController extends BaseController<CreateCinemaDTO, UpdateCinemaDTO, CinemaResponseDTO, UUID> {

    // 1. Inject CinemaService and CinemaMapper
    private final CinemaService cinemaService;

    private final CinemaMapper cinemaMapper;


    @Override
    public ResponseEntity<ApiResponse<CinemaResponseDTO>> create(CreateCinemaDTO dto) {
        // 1. Map from CreateCinemaDTO to CinemaRequestDTO
        CinemaRequestDTO requestDto = cinemaMapper.toRequest(dto);
        // 2. Call CinemaService to create Cinema entity
        CinemaResponseDTO responseDto = cinemaService.create(requestDto);
        // 3. Map from Cinema entity to CinemaResponseDTO
        return ResponseHandler.success(responseDto);
    }

    @Override
    public ResponseEntity<ApiResponse<CinemaResponseDTO>> getById(UUID uuid) {
        // 1. Call CinemaService to get Cinema entity by id
        CinemaResponseDTO responseDto = cinemaService.getById(uuid);
        // 2. Map from Cinema entity to CinemaResponseDTO
        return ResponseHandler.success(responseDto);
    }

    @Override
    public ResponseEntity<ApiResponse<Page<CinemaResponseDTO>>> getAll(PagingAndSortingRequest request) {
        // 1. Call CinemaService to get all Cinema entities with pagination
        Page<CinemaResponseDTO> responseDto = cinemaService.getAll(request.toPageable());
        // 2. Map from Cinema entity to CinemaResponseDTO
        return ResponseHandler.success(responseDto);
    }

    @Override
    public ResponseEntity<ApiResponse<CinemaResponseDTO>> update(UUID id, UpdateCinemaDTO dto) {
        // 1. Map from UpdateCinemaDTO to CinemaRequestDTO
        CinemaRequestDTO requestDto = cinemaMapper.toRequest(dto);
        // 2. Call CinemaService to update Cinema entity
        CinemaResponseDTO responseDto = cinemaService.update(id, requestDto);
        // 3. Map from Cinema entity to CinemaResponseDTO
        return ResponseHandler.success(responseDto);
    }

    @Override
    public ResponseEntity<ApiResponse<Void>> delete(UUID id) {
        // 1. Call CinemaService to delete Cinema entity
        cinemaService.delete(id);
        // 2. Return success response
        return ResponseHandler.success(null);
    }

    @GetMapping("/search-by-name")
    public ResponseEntity<ApiResponse<Page<CinemaResponseDTO>>> searchByName(@RequestParam("name") String name, @Valid @ModelAttribute PagingAndSortingRequest request) {
        // 1. Call CinemaService to search Cinema entity by name
        Page<CinemaResponseDTO> cinemaResponse = cinemaService.findByName(name, request.toPageable());
        // 2. Return success response
        return ResponseHandler.success(cinemaResponse);
    }

    @GetMapping("/search-by-city")
    public ResponseEntity<ApiResponse<Page<CinemaResponseDTO>>> searchByCity(@RequestParam("city") String city, @Valid @ModelAttribute PagingAndSortingRequest request) {
        // 1. Call CinemaService to search Cinema entity by city
        Page<CinemaResponseDTO> cinemaResponse = cinemaService.findByCity(city, request.toPageable());
        // 2. Return success response
        return ResponseHandler.success(cinemaResponse);
    }

    @GetMapping("/search-by-city-and-name")
    public ResponseEntity<ApiResponse<Page<CinemaResponseDTO>>> searchByCityAndName(@RequestParam("city") String city, @Valid @RequestParam("name") String name, @ModelAttribute PagingAndSortingRequest request) {
        // 1. Call CinemaService to search Cinema entity by city and name
        Page<CinemaResponseDTO> cinemaResponse = cinemaService.findByCityAndName(city, name, request.toPageable());
        // 2. Return success response
        return ResponseHandler.success(cinemaResponse);
    }
}

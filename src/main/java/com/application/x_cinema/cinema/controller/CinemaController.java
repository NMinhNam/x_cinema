package com.application.x_cinema.cinema.controller;

import com.application.x_cinema.cinema.dto.request.CinemaRequestDTO;
import com.application.x_cinema.cinema.dto.request.CreateCinemaDTO;
import com.application.x_cinema.cinema.dto.request.UpdateCinemaDTO;
import com.application.x_cinema.cinema.dto.response.CinemaResponseDTO;
import com.application.x_cinema.cinema.mapper.CinemaMapper;
import com.application.x_cinema.cinema.service.CinemaService;
import com.application.x_cinema.common.controller.BaseController;
import com.application.x_cinema.common.request.PagingAndSortingRequest;
import com.application.x_cinema.common.response.ApiResponse;
import com.application.x_cinema.common.response.ResponseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;
import java.util.UUID;

@RestController
@RequestMapping("/cinema")
@RequiredArgsConstructor
public class CinemaController extends BaseController<CreateCinemaDTO, UpdateCinemaDTO, CinemaResponseDTO, UUID> {

    private final CinemaService cinemaService;
    private final CinemaMapper cinemaMapper;

    @Override
    public ResponseEntity<ApiResponse<CinemaResponseDTO>> create(CreateCinemaDTO dto) {
        // Map CreateCinemaDTO sang CinemaRequestDTO
        CinemaRequestDTO requestDto = cinemaMapper.toRequest(dto);
        return ResponseHandler.success(cinemaService.create(requestDto));
    }

    @Override
    public ResponseEntity<ApiResponse<CinemaResponseDTO>> getById(UUID id) {
        // Call service
        CinemaResponseDTO responseDto = cinemaService.getById(id);


        return ResponseHandler.success(responseDto);
    }

    @Override
    public ResponseEntity<ApiResponse<Page<CinemaResponseDTO>>> getAll(PagingAndSortingRequest request) {
//        Page<CinemaResponseDTO> cinemaPage = cinemaService.getAll(request.toPageable());
//        return ResponseHandler.success(cinemaPage);
        throw new UnsupportedOperationException("Use getAll(Pageable) instead");
    }

    @Override
    public ResponseEntity<ApiResponse<CinemaResponseDTO>> update(UUID id, UpdateCinemaDTO dto) {
        return null;
    }

    @Override
    public ResponseEntity<ApiResponse<Void>> delete(UUID id) {
        cinemaService.delete(id);
        return ResponseHandler.success(null);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<ApiResponse<CinemaResponseDTO>> updateFromDTO(@PathVariable UUID id, @RequestBody UpdateCinemaDTO dto) {
//        CinemaResponseDTO updateCinema = cinemaService.updateFromDTO(id, dto);
//        return ResponseHandler.success(updateCinema);
//    }

    @GetMapping("/city/{city}")
    public ResponseEntity<ApiResponse<Page<CinemaResponseDTO>>> findByCity(@PathVariable String city, PagingAndSortingRequest request) {
        Page<CinemaResponseDTO> cinemaPage = cinemaService.findByCity(city, request.toPageable());
        return ResponseHandler.success(cinemaPage);
    }

    @GetMapping("/city/{city}/name/{name}")
    public ResponseEntity<ApiResponse<Page<CinemaResponseDTO>>> findByCityAndName(@PathVariable String city, @PathVariable String name, PagingAndSortingRequest request) {
        return ResponseHandler.success(cinemaService.findByCityAndName(city, name, request.toPageable()));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<ApiResponse<Page<CinemaResponseDTO>>> findByName(@PathVariable String name, PagingAndSortingRequest request) {
        return ResponseHandler.success(cinemaService.findByName(name, request.toPageable()));
    }
}

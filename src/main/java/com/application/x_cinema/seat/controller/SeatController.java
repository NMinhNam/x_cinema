package com.application.x_cinema.seat.controller;

import com.application.x_cinema.common.constants.ApiConstants;
import com.application.x_cinema.common.controller.BaseController;
import com.application.x_cinema.common.request.PagingAndSortingRequest;
import com.application.x_cinema.common.response.ApiResponse;
import com.application.x_cinema.common.response.ResponseHandler;
import com.application.x_cinema.seat.dto.request.CreateSeatDTO;
import com.application.x_cinema.seat.dto.request.SeatRequestDTO;
import com.application.x_cinema.seat.dto.request.UpdateSeatDTO;
import com.application.x_cinema.seat.dto.respone.SeatResponseDTO;
import com.application.x_cinema.seat.mapper.SeatMapper;
import com.application.x_cinema.seat.service.SeatService;
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
@RequestMapping(ApiConstants.Seat.BASE)
@RequiredArgsConstructor
public class SeatController extends BaseController<CreateSeatDTO, UpdateSeatDTO, SeatResponseDTO, UUID> {

    // 1. Inject the SeatService
    private final SeatService seatService;
    // 2. Inject the SeatMapper
    private final SeatMapper seatMapper;


    @Override
    public ResponseEntity<ApiResponse<SeatResponseDTO>> create(CreateSeatDTO dto) {

        // 1. Ánh xạ từ CreateSeatDTO sang SeatRequestDTO
        SeatRequestDTO requestDTO = seatMapper.toRequestDTO(dto);

        // 2. Gọi service để tạo mới Seat và trả về SeatResponseDTO
        SeatResponseDTO responseDTO = seatService.create(requestDTO);

        // 3. Trả về ApiResponse với SeatResponseDTO
        return ResponseHandler.success(responseDTO);
    }

    @Override
    public ResponseEntity<ApiResponse<SeatResponseDTO>> getById(UUID id) {

        // 1. Gọi service để lấy thông tin Seat theo uuid
        SeatResponseDTO responseDTO = seatService.getById(id);

        // 2. Trả về ApiResponse với SeatResponseDTO
        return ResponseHandler.success(responseDTO);
    }

    @Override
    public ResponseEntity<ApiResponse<Page<SeatResponseDTO>>> getAll(PagingAndSortingRequest request) {

        // 1. Gọi service để lấy danh sách Seat với phân trang và sắp xếp
        Page<SeatResponseDTO> responseDTO = seatService.getAll(request.toPageable());

        // 2. Trả về ApiResponse với danh sách SeatResponseDTO
        return ResponseHandler.success(responseDTO);
    }

    @Override
    public ResponseEntity<ApiResponse<SeatResponseDTO>> update(UUID id, UpdateSeatDTO dto) {

        // 1. Ánh xạ từ UpdateSeatDTO sang SeatRequestDTO
        SeatRequestDTO requestDTO = seatMapper.toRequestDTO(dto);

        // 2. Gọi service để cập nhật thông tin Seat và trả về SeatResponseDTO
        SeatResponseDTO responseDTO = seatService.update(id, requestDTO);

        // 3. Trả về ApiResponse với SeatResponseDTO
        return ResponseHandler.success(responseDTO);
    }

    @Override
    public ResponseEntity<ApiResponse<Void>> delete(UUID id) {

        // 1. Gọi service để xóa Seat theo uuid
        seatService.delete(id);

        // 2. Trả về ApiResponse với thông báo thành công
        return ResponseHandler.success(null);
    }

    @GetMapping("search-by-room")
    public ResponseEntity<ApiResponse<Page<SeatResponseDTO>>> getByRoomId(@RequestParam(name = "roomId") UUID roomId,
                                                                          @ModelAttribute PagingAndSortingRequest request) {

        // 1. Gọi service để tìm kiếm danh sách ghế theo phòng chiếu
        Page<SeatResponseDTO> seatResponse = seatService.getByRoomId(roomId, request.toPageable());

        // 2. Trả về ApiResponse với danh sách seatResponseDTO
        return ResponseHandler.success(seatResponse);
    }
}

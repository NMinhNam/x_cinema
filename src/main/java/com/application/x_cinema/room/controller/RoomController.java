package com.application.x_cinema.room.controller;

import com.application.x_cinema.common.constants.ApiConstants;
import com.application.x_cinema.common.controller.BaseController;
import com.application.x_cinema.common.request.PagingAndSortingRequest;
import com.application.x_cinema.common.response.ApiResponse;
import com.application.x_cinema.common.response.ResponseHandler;
import com.application.x_cinema.room.dto.request.CreateRoomDTO;
import com.application.x_cinema.room.dto.request.RoomRequestDTO;
import com.application.x_cinema.room.dto.request.UpdateRoomDTO;
import com.application.x_cinema.room.mapper.RoomMapper;
import com.application.x_cinema.room.service.RoomService;
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
@RequestMapping(ApiConstants.Room.BASE)
@RequiredArgsConstructor
public class RoomController extends BaseController<CreateRoomDTO, UpdateRoomDTO, RoomResponseDTO, UUID> {

    // Service xử lý logic cho Room
    private final RoomService roomService;

    // Map giữa DTO và Entity cho Room
    private final RoomMapper roomMapper;

    @Override
    public ResponseEntity<ApiResponse<RoomResponseDTO>> create(CreateRoomDTO dto) {

        // 1. Ánh xạ từ CreateRoomDTO sang RoomRequestDTO
        RoomRequestDTO requestDto = roomMapper.toRoomRequestDTO(dto);

        // 2. Gọi service để tạo mới Room và nhận về RoomResponseDTO
        RoomResponseDTO responseDto = roomService.create(requestDto);

        // 3. Trả về response thành công
        return ResponseHandler.success(responseDto);
    }

    @Override
    public ResponseEntity<ApiResponse<RoomResponseDTO>> getById(UUID id) {

        // 1. Gọi service để lấy Room theo ID
        RoomResponseDTO responseDto = roomService.getById(id);

        // 2. Trả về response thành công
        return ResponseHandler.success(responseDto);
    }


    @Override
    public ResponseEntity<ApiResponse<Page<RoomResponseDTO>>> getAll(PagingAndSortingRequest request) {

        // 1. Gọi service để lấy tất cả Room (có phân trang)
        Page<RoomResponseDTO> responseDto = roomService.getAll(request.toPageable());

        // 2. Trả về response thành công
        return ResponseHandler.success(responseDto);
    }

    @Override
    public ResponseEntity<ApiResponse<RoomResponseDTO>> update(UUID id, UpdateRoomDTO dto) {

        // 1. Ánh xạ từ UpdateRoomDTO sang RoomRequestDTO
        RoomRequestDTO requestDto = roomMapper.toRoomRequestDTO(dto);

        // 2. Gọi service để cập nhật Room theo ID
        RoomResponseDTO responseDto = roomService.update(id, requestDto);

        // 3. Trả về response tính công
        return ResponseHandler.success(responseDto);
    }

    @Override
    public ResponseEntity<ApiResponse<Void>> delete(UUID id) {

        // 1. Gọi service để xóa Room theo ID
        roomService.delete(id);

        // 2. Trả về response thành công
        return ResponseHandler.success(null);
    }

    @GetMapping("/search-by-cinema")
    public ResponseEntity<ApiResponse<Page<RoomResponseDTO>>> getByCinemaId(@RequestParam("cinemaId") UUID cinemaId, @ModelAttribute PagingAndSortingRequest request) {

        // 1. Gọi service để tìm Room theo cinemaId (có phân trang)
        Page<RoomResponseDTO> roomResponse = roomService.getByCinemaId(cinemaId, request.toPageable());

        // 2. Trả về response thành công
        return ResponseHandler.success(roomResponse);
    }
}

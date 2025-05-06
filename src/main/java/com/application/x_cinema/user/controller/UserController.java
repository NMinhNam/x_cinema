package com.application.x_cinema.user.controller;

import com.application.x_cinema.common.constants.ApiConstants;
import com.application.x_cinema.common.controller.BaseController;
import com.application.x_cinema.common.request.PagingAndSortingRequest;
import com.application.x_cinema.common.response.ApiResponse;
import com.application.x_cinema.common.response.ResponseHandler;
import com.application.x_cinema.user.dto.request.CreateUserDTO;
import com.application.x_cinema.user.dto.request.UpdateUserDTO;
import com.application.x_cinema.user.dto.request.UserRequestDTO;
import com.application.x_cinema.user.dto.response.UserResponseDTO;
import com.application.x_cinema.user.mapper.UserMapper;
import com.application.x_cinema.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(ApiConstants.User.BASE)
@RequiredArgsConstructor
public class UserController extends BaseController<CreateUserDTO, UpdateUserDTO, UserResponseDTO, UUID> {

    // service xử lý logic cho User
    private final UserService userService;

    // mapper chuyển đổi giữa DTO và entity
    private final UserMapper userMapper;


    @Override
    public ResponseEntity<ApiResponse<UserResponseDTO>> create(CreateUserDTO dto) {
        // 1. ánh xạ từ createUserDTO sang UserRequestDTO
        UserRequestDTO userRequestDto = userMapper.toRequest(dto);
        // 2. gọi service để tạo user
        UserResponseDTO userResponseDto = userService.create(userRequestDto);
        // 3. trả về response thành công
        return ResponseHandler.success(userResponseDto);
    }

    @Override
    public ResponseEntity<ApiResponse<UserResponseDTO>> getById(UUID id) {
        // 1. gọi service để lấy id
        UserResponseDTO userResponseDto = userService.getById(id);
        // 2. trả về response thành công
        return ResponseHandler.success(userResponseDto);
    }

    @Override
    public ResponseEntity<ApiResponse<Page<UserResponseDTO>>> getAll(PagingAndSortingRequest request, Pageable pageable) {
        // gọi service để lấy danh sách user
        Page<UserResponseDTO> userResponseDtoPage = userService.getAll(request.toPageable());
        // trả về response thành công
        return ResponseHandler.success(userResponseDtoPage);
    }

    @Override
    public ResponseEntity<ApiResponse<UserResponseDTO>> update(UUID id, UpdateUserDTO dto) {
        // 1. ánh xạ từ UpdateUserDTO sang UserRequestDTO
        UserRequestDTO userRequestDto = userMapper.toRequest(dto);
        // 2. gọi service để cập nhật user
        UserResponseDTO userResponseDto = userService.update(id, userRequestDto);
        // 3. trả về response thành công
        return ResponseHandler.success(userResponseDto);
    }

    @Override
    public ResponseEntity<ApiResponse<Void>> delete(UUID id) {
        // 1. gọi service để xóa user
        userService.delete(id);
        // 2. trả về response thành công
        return ResponseHandler.success(null);
    }

}

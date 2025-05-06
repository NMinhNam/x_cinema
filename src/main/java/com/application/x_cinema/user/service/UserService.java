package com.application.x_cinema.user.service;

import com.application.x_cinema.common.service.BaseService;
import com.application.x_cinema.user.dto.request.UserRequestDTO;
import com.application.x_cinema.user.dto.response.UserResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface UserService extends BaseService<UserRequestDTO, UserResponseDTO, UUID> {

}

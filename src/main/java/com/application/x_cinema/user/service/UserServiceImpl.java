package com.application.x_cinema.user.service;

import com.application.x_cinema.common.enums.ErrorCode;
import com.application.x_cinema.common.exception.AppException;
import com.application.x_cinema.user.dto.request.UserRequestDTO;
import com.application.x_cinema.user.dto.response.UserResponseDTO;
import com.application.x_cinema.user.entity.User;
import com.application.x_cinema.user.mapper.UserMapper;
import com.application.x_cinema.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;


    @Override
    @Transactional
    public UserResponseDTO create(UserRequestDTO dto) {
        // 1. Convert dto to entity
        User user = userMapper.toEntity(dto);
        // 2. Save entity
        User savedUser = userRepository.save(user);
        // 3. Convert entity to dto
        return userMapper.toResponse(savedUser);
    }

    @Override
    @Transactional
    public UserResponseDTO update(UUID id, UserRequestDTO dto) {
        // 1. Get user by id
        User user = userRepository.findById(id)
                                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));
        // 2. Update user
        userMapper.updateEntityFromDTO(dto, user);
        // 3. Save user
        User savedUser = userRepository.save(user);
        // 4. Convert entity to dto
        return userMapper.toResponse(savedUser);
    }

    @Override
    public UserResponseDTO getById(UUID id) {
        // 1. Get user by id
        User user = userRepository.findById(id)
                                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));
        // 2. Convert entity to dto
        return userMapper.toResponse(user);
    }

    @Override
    public Page<UserResponseDTO> getAll(Pageable pageable) {
        // 1. Get all users
        Page<User> userPage = userRepository.findAll(pageable);
        // 2. Convert entity to dto
        return userPage.map(userMapper::toResponse);
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        // 1. Get user by id
        User user = userRepository.findById(id)
                                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));
        // 2. Delete user
        userRepository.delete(user);
    }
}

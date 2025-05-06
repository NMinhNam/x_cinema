package com.application.x_cinema.user.mapper;

import com.application.x_cinema.common.mapper.BaseMapper;
import com.application.x_cinema.user.dto.request.CreateUserDTO;
import com.application.x_cinema.user.dto.request.UpdateUserDTO;
import com.application.x_cinema.user.dto.request.UserRequestDTO;
import com.application.x_cinema.user.dto.response.UserResponseDTO;
import com.application.x_cinema.user.entity.User;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<UserRequestDTO, UserResponseDTO, User> {

    // 1. Anh xa tu request sang entity
    @Override
    @Mapping(target = "id", ignore = true)
    User toEntity(UserRequestDTO requestDto);

    // 2. Anh xa tu entity sang response
    @Override
    @Mapping(source = "id", target = "id")
    UserResponseDTO toResponse(User user);

    // 3. Anh xa tu createUserDTO sang UserRequestDTO
    UserRequestDTO toRequest(CreateUserDTO dto);

    // 4. Anh xa tu UpdateUserDTO sang UserRequestDTO
    UserRequestDTO toRequest(UpdateUserDTO dto);

    // 5. Update tu UserRequestDTO sang User (bo qua cac truong null)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDTO(UserRequestDTO requestDto, @MappingTarget User user);
}

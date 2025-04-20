package com.application.x_cinema.room.mapper;

import com.application.x_cinema.common.mapper.BaseMapper;
import com.application.x_cinema.room.dto.request.CreateRoomDTO;
import com.application.x_cinema.room.dto.request.RoomRequestDTO;
import com.application.x_cinema.room.dto.request.UpdateRoomDTO;
import com.application.x_cinema.room.dto.respone.RoomResponseDTO;
import com.application.x_cinema.room.entity.Room;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface RoomMapper extends BaseMapper<RoomRequestDTO, RoomResponseDTO, Room> {
    // Anh xa tu RoomRequestDTO -> Room
    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "cinemaId", target = "cinema.id")
    Room toEntity(RoomRequestDTO requestDto);

    // Anh xa tu Room -> RoomResponseDTO
        @Override
        @Mapping(source = "cinema.id", target = "cinemaId")
        RoomResponseDTO toResponse(Room room);

    // CreateRoomDTO -> RoomRequestDTO
    RoomRequestDTO toRoomRequestDTO(CreateRoomDTO createRoomDTO);

    // UpdateRoomDTO -> RoomRequestDTO
    RoomRequestDTO toRoomRequestDTO(UpdateRoomDTO updateRoomDTO);

    // Update từ DTO vào Entity (bỏ qua các trường null)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDTO(RoomRequestDTO dto, @MappingTarget Room room);
}

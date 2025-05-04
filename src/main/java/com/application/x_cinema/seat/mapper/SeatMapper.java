package com.application.x_cinema.seat.mapper;

import com.application.x_cinema.common.mapper.BaseMapper;
import com.application.x_cinema.seat.dto.request.CreateSeatDTO;
import com.application.x_cinema.seat.dto.request.SeatRequestDTO;
import com.application.x_cinema.seat.dto.request.UpdateSeatDTO;
import com.application.x_cinema.seat.dto.respone.SeatResponseDTO;
import com.application.x_cinema.seat.entity.Seat;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface SeatMapper extends BaseMapper<SeatRequestDTO, SeatResponseDTO, Seat> {

    // 1. Mapping from SeatRequestDTO to Seat entity
    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "roomId", target = "room.id")
    @Mapping(source = "seatType", target = "seatType")
    @Mapping(source = "seatStatus", target = "seatStatus")
    Seat toEntity(SeatRequestDTO requestDTO);

    // 2. Mapping from Seat entity to SeatResponseDTO
    @Override
    @Mapping(source = "room.id", target = "roomId")
    SeatResponseDTO toResponse(Seat seat);

    // 3. Mapping from CreateSeatDTO to SeatRequestDTO
    SeatRequestDTO toRequestDTO(CreateSeatDTO createSeatDTO);

    // 4. Mapping from UpdateSeatDTO to SeatRequestDTO
    SeatRequestDTO toRequestDTO(UpdateSeatDTO updateSeatDTO);

    // 5. Update entity from DTO (skip null values)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDTO(SeatRequestDTO dto, @MappingTarget Seat seat);
}

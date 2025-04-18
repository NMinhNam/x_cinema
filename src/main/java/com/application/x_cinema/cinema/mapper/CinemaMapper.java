package com.application.x_cinema.cinema.mapper;

import com.application.x_cinema.cinema.dto.request.CinemaRequestDTO;
import com.application.x_cinema.cinema.dto.request.CreateCinemaDTO;
import com.application.x_cinema.cinema.dto.request.UpdateCinemaDTO;
import com.application.x_cinema.cinema.dto.response.CinemaResponseDTO;
import com.application.x_cinema.cinema.entity.Cinema;
import com.application.x_cinema.common.mapper.BaseMapper;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;


@Mapper(componentModel = "spring")
public interface CinemaMapper extends BaseMapper<CinemaRequestDTO, CinemaResponseDTO, Cinema> {

    // Map from CinemaRequestDTO sang Entity
    @Override
    @Mapping(target = "id", ignore = true)
    Cinema toEntity(CinemaRequestDTO requestDto);

    // Map from Entity sang CinemaResponseDTO
    @Override
    CinemaResponseDTO toResponse(Cinema entity);

    // Map from CreateCinemaDTO sang CinemaRequestDTO
    CinemaRequestDTO toRequest(CreateCinemaDTO createCinemaDTO);

    // Map from UpdateCinemaDTO sang CinemaRequestDTO
    CinemaRequestDTO toRequest(UpdateCinemaDTO updateCinemaDTO);

    // Update Cinema from UpdateCinemaDTO
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDTO(UpdateCinemaDTO dto, @MappingTarget Cinema entity);
}

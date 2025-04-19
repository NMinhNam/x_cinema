package com.application.x_cinema.genre.mapper;

import com.application.x_cinema.common.mapper.BaseMapper;
import com.application.x_cinema.genre.dto.request.GenreRequestDTO;
import com.application.x_cinema.genre.dto.response.GenreResponseDTO;
import com.application.x_cinema.genre.entity.Genre;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GenreMapper extends BaseMapper<GenreRequestDTO, GenreResponseDTO, Genre> {
}

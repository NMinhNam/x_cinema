package com.application.x_cinema.movie.mapper;

import com.application.x_cinema.common.mapper.BaseMapper;
import com.application.x_cinema.movie.dto.request.MovieRequestDTO;
import com.application.x_cinema.movie.dto.response.MovieResponseDTO;
import com.application.x_cinema.movie.entity.Movie;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MovieMapper extends BaseMapper<MovieRequestDTO, MovieResponseDTO, Movie> {
}

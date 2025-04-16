package com.application.x_cinema.movie.mapper;

import com.application.x_cinema.common.mapper.BaseMapper;
import com.application.x_cinema.movie.dto.request.MovieRequestDTO;
import com.application.x_cinema.movie.dto.response.MovieResponseDTO;
import com.application.x_cinema.movie.entity.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MovieMapper extends BaseMapper<MovieRequestDTO, MovieResponseDTO, Movie> {
    // Ánh xạ từ MovieRequestDTO sang Movie
    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "genre", ignore = true)
    Movie toEntity(MovieRequestDTO requestDto);

    // Ánh xạ từ Movie sang MovieResponseDTO
    @Override
    @Mapping(source = "genre.genreName", target = "genre")
    MovieResponseDTO toResponse(Movie movie);
}

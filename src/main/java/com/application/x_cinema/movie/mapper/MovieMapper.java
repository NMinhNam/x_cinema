package com.application.x_cinema.movie.mapper;

import com.application.x_cinema.common.mapper.BaseMapper;
import com.application.x_cinema.movie.dto.request.CreateMovieDTO;
import com.application.x_cinema.movie.dto.request.MovieRequestDTO;
import com.application.x_cinema.movie.dto.request.UpdateMovieDTO;
import com.application.x_cinema.movie.dto.response.MovieResponseDTO;
import com.application.x_cinema.movie.entity.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MovieMapper extends BaseMapper<MovieRequestDTO, MovieResponseDTO, Movie> {
    // Ánh xạ từ MovieRequestDTO sang Movie
    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "genreId", target = "genre.id")
    Movie toEntity(MovieRequestDTO requestDto);

    // Ánh xạ từ Movie sang MovieResponseDTO
    @Override
    @Mapping(source = "genre.genreName", target = "genreId")
    MovieResponseDTO toResponse(Movie movie);

    // Ánh xạ từ CreateMovieDTO sang MovieRequestDTO
    MovieRequestDTO toRequest(CreateMovieDTO dto);

    // Ánh xạ từ CreateMovieDTO sang MovieRequestDTO
    MovieRequestDTO toRequest(UpdateMovieDTO dto);
}

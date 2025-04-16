package com.application.x_cinema.movie.service;

import com.application.x_cinema.common.enums.ErrorCode;
import com.application.x_cinema.common.exception.AppException;
import com.application.x_cinema.movie.dto.request.MovieRequestDTO;
import com.application.x_cinema.movie.dto.response.MovieResponseDTO;
import com.application.x_cinema.movie.entity.Movie;
import com.application.x_cinema.movie.mapper.MovieMapper;
import com.application.x_cinema.movie.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    private final MovieMapper movieMapper;

    @Override
    public MovieResponseDTO create(MovieRequestDTO dto) {
        return null;
    }

    @Override
    public MovieResponseDTO update(UUID uuid, MovieRequestDTO dto) {
        return null;
    }

    @Override
    public MovieResponseDTO getById(UUID uuid) {
        return movieRepository.findById(uuid)
                .map(movieMapper::toResponse)
                .orElseThrow(() -> new AppException(ErrorCode.INTERNAL_ERROR));
    }

    @Override
    public Page<MovieResponseDTO> getAll(Pageable pageable) {
        Page<Movie> moviePage = movieRepository.findAll(pageable);
        return moviePage.map(movieMapper::toResponse);
    }

    @Override
    public void delete(UUID uuid) {
    }

    @Override
    public Page<MovieResponseDTO> findById(UUID movieId, Pageable pageable) {
        Page<Movie> moviePage = movieRepository.findById(movieId, pageable);
        return moviePage.map(movieMapper::toResponse);
    }
}

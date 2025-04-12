package com.application.x_cinema.movie.service;

import com.application.x_cinema.movie.dto.request.MovieRequestDTO;
import com.application.x_cinema.movie.dto.response.MovieResponseDTO;
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
    public Optional<MovieResponseDTO> getById(UUID uuid) {
        return Optional.empty();
    }

    @Override
    public Page<MovieResponseDTO> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public void delete(UUID uuid) {
    }
}

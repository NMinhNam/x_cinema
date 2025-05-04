package com.application.x_cinema.movie.service;

import com.application.x_cinema.common.enums.ErrorCode;
import com.application.x_cinema.common.exception.AppException;
import com.application.x_cinema.movie.dto.request.MovieRequestDTO;
import com.application.x_cinema.movie.dto.response.MovieResponseDTO;
import com.application.x_cinema.movie.entity.Movie;
import com.application.x_cinema.movie.mapper.MovieMapper;
import com.application.x_cinema.movie.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    private final MovieMapper movieMapper;

    @Override
    public MovieResponseDTO create(MovieRequestDTO dto) {
        // Map DTO REQ -> ENTITY
        Movie movie = movieMapper.toEntity(dto);

        // Save DB
        movieRepository.save(movie);

        // Map ENTITY -> DTO RES
        return movieMapper.toResponse(movie);
    }

    @Override
    public MovieResponseDTO update(UUID uuid, MovieRequestDTO dto) {
        return null;
    }

    @Cacheable(value = "movies", key = "#uuid")
    @Override
    public MovieResponseDTO getById(UUID uuid) {

        // Giả định tốc độ api
        try {
            Thread.sleep(5000); // 5000ms = 5 giây
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return movieRepository.findById(uuid)
                .map(movieMapper::toResponse)
                .orElseThrow(() -> new AppException(ErrorCode.INTERNAL_ERROR));
    }

    @Override
    public Page<MovieResponseDTO> getAll(Pageable pageable) {
        Page<Movie> moviePage = movieRepository.findAll(pageable);
        return moviePage.map(movieMapper::toResponse);
    }

    @CacheEvict(value = "movies", key = "#uuid")
    @Override
    public void delete(UUID uuid) {
        movieRepository.deleteById(uuid);
    }

    @Override
    public Page<MovieResponseDTO> getByGenreId(UUID genreId, Pageable pageable) {
        Page<Movie> moviePage = movieRepository.findByGenreId(genreId, pageable);
        return moviePage.map(movieMapper::toResponse);
    }
}
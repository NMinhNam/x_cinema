package com.application.x_cinema.movie.service;

import com.application.x_cinema.movie.dto.response.MovieResponse;
import com.application.x_cinema.movie.entity.Movie;
import com.application.x_cinema.movie.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService{

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public MovieResponse create(MovieResponse dto) {
        return null;
    }

    @Override
    public MovieResponse update(UUID uuid, MovieResponse dto) {
        return null;
    }

    @Override
    public Optional<MovieResponse> getById(UUID uuid) {
        return Optional.empty();
    }

    @Override
    public List<MovieResponse> getAll() {
        return movieRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(UUID uuid) {
    }

    // Tạm thời để đây :)
    private MovieResponse toResponse(Movie movie) {
        MovieResponse response = new MovieResponse();
        response.setId(movie.getId().toString());
        response.setTitle(movie.getTitle());
        response.setGenre(movie.getGenre());
        response.setDuration(movie.getDuration());
        response.setPosterUrl(movie.getPosterUrl());
        return response;
    }
}

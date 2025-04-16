package com.application.x_cinema.movie.repository;

import com.application.x_cinema.movie.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MovieRepository extends JpaRepository<Movie, UUID> {
    Page<Movie> findById(UUID movieId, Pageable pageable);
}
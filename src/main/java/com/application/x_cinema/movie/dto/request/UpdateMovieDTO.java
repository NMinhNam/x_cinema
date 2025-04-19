package com.application.x_cinema.movie.dto.request;

import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UpdateMovieDTO {
    @Size(max = 255, message = "Movie name must not exceed 255 characters")
    private String name;

    private String description;

    @PositiveOrZero(message = "Duration must be a positive number or zero")
    private Integer duration;

    @Size(max = 255, message = "Poster URL must not exceed 255 characters")
    private String poster_url;

    @Size(max = 50, message = "Language must not exceed 50 characters")
    private String language;

    @Size(max = 20, message = "Movie status must not exceed 20 characters")
    private String movie_status;

    private UUID genre_id;

    @Size(max = 255, message = "Director must not exceed 255 characters")
    private String director;

    private String actor;
}

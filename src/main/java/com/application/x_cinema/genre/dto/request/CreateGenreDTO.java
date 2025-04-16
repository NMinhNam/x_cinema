package com.application.x_cinema.genre.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CreateGenreDTO {
    @NotBlank(message = "Movie name is required")
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

    @NotNull(message = "Genre ID is required")
    private UUID genre_id;

    @Size(max = 255, message = "Director must not exceed 255 characters")
    private String director;

    private String actor;

    @NotNull(message = "Base price is required")
    @PositiveOrZero(message = "Base price must be a positive number or zero")
    private Double base_price;
}

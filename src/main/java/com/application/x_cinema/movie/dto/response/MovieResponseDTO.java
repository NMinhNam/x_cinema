package com.application.x_cinema.movie.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieResponseDTO {
    private UUID movieId;

    private String name;

    private String description;

    private Integer duration;

    private String posterURL;

    private String language;

    private String movieStatus;

    private String genre;

    private String director;

    private String actor;
}

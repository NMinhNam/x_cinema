package com.application.x_cinema.movie.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateMovieDTO {
    private String title;

    private String genre;

    private Integer duration;

    private String posterUrl;
}

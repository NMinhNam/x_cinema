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
public class MovieRequestDTO {
    private String title;

    private String genre;

    private int duration;

    private String posterUrl;
}

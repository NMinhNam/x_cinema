package com.application.x_cinema.movie.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieResponseDTO {
    private String id;

    private String title;

    private String genre;

    private int duration;

    private String posterUrl;


}

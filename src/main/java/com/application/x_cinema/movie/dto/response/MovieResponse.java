package com.application.x_cinema.movie.dto.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MovieResponse {
    private String id;

    private String title;

    private String genre;

    private int duration;

    private String posterUrl;

    public MovieResponse() {
    }

    public MovieResponse(String id, String title, String genre, int duration, String posterUrl) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.posterUrl = posterUrl;
    }

}

package com.application.x_cinema.movie.entity;

import com.application.x_cinema.genre.entity.Genre;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "movie")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Movie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "movie_id")
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "poster_url")
    private String posterURL;

    @Column(name = "language", length = 50)
    private String language;

    @Column(name = "movie_status", length = 20)
    private String movieStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_id", referencedColumnName = "genre_id")
    private Genre genre;

    @Column(name = "director")
    private String director;

    @Column(name = "actor", columnDefinition = "TEXT")
    private String actor;
}
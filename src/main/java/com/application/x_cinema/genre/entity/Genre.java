package com.application.x_cinema.genre.entity;

import com.application.x_cinema.movie.entity.Movie;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "genre")
@Getter
@Setter
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "genre_id")
    private UUID id;

    @Column(name = "genre_name", nullable = false, length = 50)
    private String genreName;

    @OneToMany(mappedBy = "genre",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Movie> movies;
}

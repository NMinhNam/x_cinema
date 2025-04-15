CREATE TABLE genre
(
    genre_id   uuid        NOT NULL
        PRIMARY KEY,
    genre_name VARCHAR(50) NOT NULL
);

CREATE TABLE movie
(
    movie_id     uuid         NOT NULL
        PRIMARY KEY,
    name         VARCHAR(255) NOT NULL,
    description  TEXT,
    duration     INTEGER,
    poster_url   VARCHAR(255),
    language     VARCHAR(50),
    movie_status VARCHAR(20),
    genre_id     uuid
        REFERENCES genre,
    director     VARCHAR(255),
    actor        TEXT
);

CREATE TABLE user
(
    user_id uuid         NOT NULL
        PRIMARY KEY,
    name VARCHAR(255),
    password VARCHAR(255)
);

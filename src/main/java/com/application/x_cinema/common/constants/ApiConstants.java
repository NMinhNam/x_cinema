package com.application.x_cinema.common.constants;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public final class ApiConstants {
    public static final String BASE_API = "/api";
    public static final String VERSION_V1 = BASE_API + "/v1";

    // ---------- MOVIE ----------
    public static final class Movie {
        public static final String BASE = VERSION_V1 + "/movies";
        public static final String GET_ALL = BASE;
        public static final String GET_BY_ID = BASE + "/{id}";
        public static final String CREATE = BASE;
        public static final String UPDATE = BASE + "/{id}";
        public static final String DELETE = BASE + "/{id}";
        public static final String SEARCH = BASE + "/search";
    }

    // ---------- GENRE ----------
    public static final class Genre {
        public static final String BASE = BASE_API + "/genres";
        public static final String GET_ALL = BASE;
        public static final String GET_BY_ID = BASE + "/{id}";
        public static final String CREATE = BASE;
        public static final String UPDATE = BASE + "/{id}";
        public static final String DELETE = BASE + "/{id}";
        public static final String SEARCH = BASE + "/search";
    }

    // ---------- ROOM ----------
    public static final class Room {
        public static final String BASE = VERSION_V1 + "/rooms";
        public static final String GET_ALL = BASE;
        public static final String GET_BY_ID = BASE + "/{id}";
        public static final String GET_BY_CINEMA_ID = BASE + "/cinema/{cinemaId}";
        public static final String CREATE = BASE;
        public static final String UPDATE = BASE + "/{id}";
        public static final String DELETE = BASE + "/{id}";
        public static final String SEARCH = BASE + "/search";
    }
}

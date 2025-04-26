package com.application.x_cinema.common.constants;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public final class ApiConstants {
    public static final String BASE_API = "/api";
    public static final String VERSION_V1 = BASE_API + "/v1";

    // ---------- MOVIE ----------
        public static final String MOVIE = VERSION_V1 + "/movies";
    // ---------- GENRE ----------
        public static final String GENRE = VERSION_V1 + "/genres";
}

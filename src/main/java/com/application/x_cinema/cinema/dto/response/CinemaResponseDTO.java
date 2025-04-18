package com.application.x_cinema.cinema.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CinemaResponseDTO {
    private UUID id;

    private String name;

    private String address;

    private String city;

    private String phoneNumber;

    private String email;
}

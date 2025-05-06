package com.application.x_cinema.user.dto.response;

import com.application.x_cinema.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponseDTO {
    private UUID id;

    private String username;

    private String fullname;

    private String email;

    private String phone;

    private LocalDate date;

    private User.Gender gender;

    private User.Role role;

    private User.Status status;
}

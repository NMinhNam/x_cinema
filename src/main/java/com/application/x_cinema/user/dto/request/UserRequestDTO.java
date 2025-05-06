package com.application.x_cinema.user.dto.request;

import com.application.x_cinema.user.entity.User;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserRequestDTO {
    @Size(max = 255, message = "Username must not exceed 255 characters")
    private String username;

    @Size(min = 8, max = 255, message = "Password must be between 8 and 255 characters")
    private String password;

    @Size(max = 255, message = "Full name must not exceed 255 characters")
    private String fullname;

    @Size(max = 255, message = "Email must not exceed 255 characters")
    private String email;

    @Size(max = 20, message = "Phone number must not exceed 20 characters")
    private String phone;

    private LocalDate date;

    private User.Gender gender;

    private User.Role role;

    private User.Status status;
}

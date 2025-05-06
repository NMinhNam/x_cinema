package com.application.x_cinema.user.dto.request;

import com.application.x_cinema.user.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UpdateUserDTO {
    @Size(min = 8, max = 255, message = "Password must be between 8 and 255 characters")
    private String password;

    @Size(max = 255, message = "Full name must not exceed 255 characters")
    private String fullname;

    @Email(message = "Invalid email format")
    @Size(max = 255, message = "Email must not exceed 255 characters")
    private String email;

    @Pattern(regexp = "^\\+?[0-9]{7,20}$", message = "Invalid phone number format")
    @Size(max = 20, message = "Phone number must not exceed 20 characters")
    private String phone;

    @Past(message = "Date of birth must be in the past")
    private LocalDate date;

    @NotNull(message = "Gender is required")
    private User.Gender gender;

    @NotNull(message = "Role is required")
    private User.Role role;

    @NotNull(message = "Status is required")
    private User.Status status;

}

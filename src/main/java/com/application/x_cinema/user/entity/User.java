package com.application.x_cinema.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "userid")
    private UUID id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "fullname", nullable = false)
    private String fullname;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "phonenumber")
    private String phone;

    @Column(name = "dateofbirth")
    private LocalDate date;


    public enum Gender {
        Male, Female, Unknown
    }
    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    public enum Role {
        Customer, Admin, Staff
    }
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    public enum Status {
        Active, Inactive, Banned
    }
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;
}

package com.application.x_cinema.room.entity;

import com.application.x_cinema.cinema.entity.Cinema;
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
@Table(name = "room")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Room implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "room_id")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cinema_id", referencedColumnName = "cinema_id")
    private Cinema cinema;

    @Column(name = "room_name", nullable = false)
    private String roomName;

    @Column(name = "room_type")
    private String roomType;

    @Column(name = "total_seat")
    private Integer totalSeat;

    @Column(name = "surcharge")
    private Integer surcharge;

}

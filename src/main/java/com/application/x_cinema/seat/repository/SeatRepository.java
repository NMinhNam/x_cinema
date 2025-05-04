package com.application.x_cinema.seat.repository;

import com.application.x_cinema.seat.entity.Seat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SeatRepository extends JpaRepository<Seat, UUID> {
    Page<Seat> findByRoomId(UUID roomId, Pageable pageable);
}

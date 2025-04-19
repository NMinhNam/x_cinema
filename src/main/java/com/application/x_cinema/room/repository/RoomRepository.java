package com.application.x_cinema.room.repository;

import com.application.x_cinema.room.entity.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoomRepository extends JpaRepository<Room, UUID> {
    Page<Room> findByCinemaId(UUID cinemaId, Pageable pageable);
}

package com.application.x_cinema.cinema.repository;

import com.application.x_cinema.cinema.entity.Cinema;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, UUID> {
    /**
     *
     * @param city
     * @param pageable
     * @return
     * Tìm rạp phim theo thành pho rồi phân trang
     */
    Page<Cinema> findByCityContainingIgnoreCase(String city, Pageable pageable);

    /**
     *
     * @param name
     * @param pageable
     * @return
     * Tìm rạp phim theo tên rạp phim rồi phân trang
     */
    Page<Cinema> findByNameContainingIgnoreCase(String name, Pageable pageable);

    /**
     *
     * @param city
     * @param name
     * @param pageable
     * @return
     * Tìm rạp phim theo thành phố và tên rạp phim rồi phân trang
     */
    Page<Cinema> findByCityAndNameContainingIgnoreCase( String city, String name, Pageable pageable);
}

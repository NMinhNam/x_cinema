package com.application.x_cinema.common.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Base Service
 * @param <REQ> Request DTO
 * @param <RES> Response DTO
 * @param <ID> Data type ID
 */
public interface BaseService<REQ, RES, ID> {
    RES create(REQ dto);

    RES update(ID id, REQ dto);

    Optional<RES> getById(ID id);

    Page<RES> getAll(Pageable pageable);

    void delete(ID id);
}
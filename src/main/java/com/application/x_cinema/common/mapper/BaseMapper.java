package com.application.x_cinema.common.mapper;

import java.util.List;

/**
 * Base Mapper
 * @param <REQ> Request DTO
 * @param <RES> Response DTO
 * @param <E> Entity
 */
public interface BaseMapper<REQ, RES, E> {
    E toEntity(REQ requestDto);

    RES toResponse(E entity);

    List<E> toEntityList(List<REQ> requestDtoList);

    List<RES> toResponseList(List<E> entityList);
}

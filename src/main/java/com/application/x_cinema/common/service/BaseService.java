package com.application.x_cinema.common.service;

import java.util.List;
import java.util.Optional;

public interface BaseService<T, ID> {
    T create(T dto);

    T update(ID id, T dto);

    Optional<T> getById(ID id);

    List<T> getAll();

    void delete(ID id);
}
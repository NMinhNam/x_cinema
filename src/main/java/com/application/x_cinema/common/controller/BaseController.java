package com.application.x_cinema.common.controller;

import com.application.x_cinema.common.response.ApiResponse;
import com.application.x_cinema.common.service.BaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public abstract class BaseController<T, ID> {

    protected final BaseService<T, ID> service;

    protected BaseController(BaseService<T, ID> service) {
        this.service = service;
    }

    public abstract ResponseEntity<ApiResponse<T>> create(@RequestBody T dto);

    public abstract ResponseEntity<ApiResponse<T>> getById(@PathVariable ID id);

    public abstract ResponseEntity<ApiResponse<List<T>>> getAll();

    public abstract ResponseEntity<ApiResponse<T>> update(@PathVariable ID id, @RequestBody T dto);

    public abstract ResponseEntity<ApiResponse<Void>> delete(@PathVariable ID id);
}
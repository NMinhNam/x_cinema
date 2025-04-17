package com.application.x_cinema.common.controller;

import com.application.x_cinema.common.request.PagingAndSortingRequest;
import com.application.x_cinema.common.response.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Base Controller
 * @param <CREATE> Create DTO
 * @param <UPDATE> Update  DTO
 * @param <RES> Response DTO
 * @param <ID> Data type ID
 */
public abstract class BaseController<CREATE, UPDATE, RES, ID> {

    @PostMapping()
    public abstract ResponseEntity<ApiResponse<RES>> create(@RequestBody @Valid CREATE dto);

    @GetMapping("/{id}")
    public abstract ResponseEntity<ApiResponse<RES>> getById(@PathVariable("id") ID id);

    @GetMapping()
    public abstract ResponseEntity<ApiResponse<Page<RES>>> getAll(@ModelAttribute PagingAndSortingRequest request);

    @PutMapping("/{id}")
    public abstract ResponseEntity<ApiResponse<RES>> update(@PathVariable ID id, @RequestBody @Valid UPDATE dto);

    @DeleteMapping("/{id}")
    public abstract ResponseEntity<ApiResponse<Void>> delete(@PathVariable ID id);
}
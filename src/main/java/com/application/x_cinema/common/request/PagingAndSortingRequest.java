package com.application.x_cinema.common.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import net.bytebuddy.implementation.bind.annotation.Default;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Getter
@Setter
public class PagingAndSortingRequest {
    @Min(0)
    private int page = 0;

    @Min(10)
    private int size = 10;

    private String sort = "id";

    @Pattern(regexp = "asc|desc", flags = Pattern.Flag.CASE_INSENSITIVE)
    private String direction = "desc";

    public Sort toSort() {
        return Sort.by(new Sort.Order(Sort.Direction.fromString(direction), sort));
    }

    public Pageable toPageable() {
        return PageRequest.of(page, size, toSort());
    }
}

package com.application.x_cinema.voucher.dto.request;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UpdateVoucherDTO {
    @Size(max = 50, message = "Voucher code must not exceed 50 characters")
    private String voucherCode;

    private Double discountPercent;

    @Future(message = "Expiry date must be in the future")
    private LocalDate expiryDate;

    private Double minOrderAmount;

    private Double maxDiscountAmount;

    private boolean active;
}

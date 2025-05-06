package com.application.x_cinema.voucher.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VoucherResponseDTO {
    private UUID id;

    private String voucherCode;

    private Double discountPercent;

    private LocalDate expiryDate;

    private Double minOrderAmount;

    private Double maxDiscountAmount;

    private boolean active;
}

package com.application.x_cinema.voucher.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "voucher")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "voucherid")
    private UUID id;

    @Column(name = "vouchercode", unique = true)
    private String voucherCode;

    @Column(name = "discountpercent")
    private Double discountPercent;

    @Column(name = "expirydate")
    private LocalDate expiryDate;

    @Column(name = "minorderamount")
    private Double minOrderAmount;

    @Column(name = "maxdiscountamount")
    private Double maxDiscountAmount;

    @Column(name = "isactive")
    private boolean active;
}

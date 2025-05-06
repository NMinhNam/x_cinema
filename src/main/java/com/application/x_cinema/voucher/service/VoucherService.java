package com.application.x_cinema.voucher.service;

import com.application.x_cinema.common.service.BaseService;
import com.application.x_cinema.voucher.dto.request.VoucherRequestDTO;
import com.application.x_cinema.voucher.dto.response.VoucherResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface VoucherService extends BaseService<VoucherRequestDTO, VoucherResponseDTO, UUID> {
}

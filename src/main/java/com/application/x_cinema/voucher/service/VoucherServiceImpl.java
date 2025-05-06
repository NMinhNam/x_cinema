package com.application.x_cinema.voucher.service;

import com.application.x_cinema.common.enums.ErrorCode;
import com.application.x_cinema.common.exception.AppException;
import com.application.x_cinema.voucher.dto.request.VoucherRequestDTO;
import com.application.x_cinema.voucher.dto.response.VoucherResponseDTO;
import com.application.x_cinema.voucher.entity.Voucher;
import com.application.x_cinema.voucher.mapper.VoucherMapper;
import com.application.x_cinema.voucher.repository.VoucherRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VoucherServiceImpl implements VoucherService {

    private final VoucherMapper voucherMapper;

    private final VoucherRepository voucherRepository;

    @Override
    @Transactional
    public VoucherResponseDTO create(VoucherRequestDTO dto) {
        // 1. Convert dto to entity
        Voucher voucher = voucherMapper.toEntity(dto);
        // 2. Save entity
        Voucher savedVoucher = voucherRepository.save(voucher);
        // 3. Convert entity to dto
        return voucherMapper.toResponse(savedVoucher);
    }

    @Override
    @Transactional
    public VoucherResponseDTO update(UUID id, VoucherRequestDTO dto) {
        // 1. Get voucher by id
        Voucher voucher = voucherRepository.findById(id)
                                        .orElseThrow(() -> new AppException(ErrorCode.VOUCHER_NOT_FOUND));
        // 2. Update voucher
        voucherMapper.updateEntityFromDTO(dto, voucher);
        // 3. Save voucher
        Voucher savedVoucher = voucherRepository.save(voucher);
        // 4. Convert entity to dto
        return voucherMapper.toResponse(savedVoucher);
    }

    @Override
    public VoucherResponseDTO getById(UUID id) {
        // 1. Get voucher by id
        Voucher voucher = voucherRepository.findById(id)
                                        .orElseThrow(() -> new AppException(ErrorCode.VOUCHER_NOT_FOUND));
        // 2. Convert entity to dto
        return voucherMapper.toResponse(voucher);
    }

    @Override
    public Page<VoucherResponseDTO> getAll(Pageable pageable) {
        // 1. Get all vouchers
        Page<Voucher> voucherPage = voucherRepository.findAll(pageable);
        // 2. Convert entity to dto
        return voucherPage.map(voucherMapper::toResponse);
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        // 1. Get voucher by id
        Voucher voucher = voucherRepository.findById(id)
                                        .orElseThrow(() -> new AppException(ErrorCode.VOUCHER_NOT_FOUND));
        // 2. Delete voucher
        voucherRepository.delete(voucher);
    }


}

package com.application.x_cinema.voucher.controller;

import com.application.x_cinema.common.constants.ApiConstants;
import com.application.x_cinema.common.controller.BaseController;
import com.application.x_cinema.common.request.PagingAndSortingRequest;
import com.application.x_cinema.common.response.ApiResponse;
import com.application.x_cinema.common.response.ResponseHandler;
import com.application.x_cinema.voucher.dto.request.CreateVoucherDTO;
import com.application.x_cinema.voucher.dto.request.UpdateVoucherDTO;
import com.application.x_cinema.voucher.dto.request.VoucherRequestDTO;
import com.application.x_cinema.voucher.dto.response.VoucherResponseDTO;
import com.application.x_cinema.voucher.mapper.VoucherMapper;
import com.application.x_cinema.voucher.service.VoucherService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(ApiConstants.Voucher.BASE)
@RequiredArgsConstructor
public class VoucherController extends BaseController<CreateVoucherDTO, UpdateVoucherDTO, VoucherResponseDTO, UUID> {

    private final VoucherService voucherService;

    private final VoucherMapper voucherMapper;

    @Override
    public ResponseEntity<ApiResponse<VoucherResponseDTO>> create(CreateVoucherDTO dto) {
        VoucherRequestDTO voucherRequestDTO = voucherMapper.toRequest(dto);
        VoucherResponseDTO voucherResponseDTO = voucherService.create(voucherRequestDTO);
        return ResponseHandler.success(voucherResponseDTO);
    }

    @Override
    public ResponseEntity<ApiResponse<VoucherResponseDTO>> update(UUID id, UpdateVoucherDTO dto) {
        VoucherRequestDTO voucherRequestDTO = voucherMapper.toRequest(dto);
        VoucherResponseDTO voucherResponseDTO = voucherService.update(id, voucherRequestDTO);
        return ResponseHandler.success(voucherResponseDTO);
    }

    @Override
    public ResponseEntity<ApiResponse<VoucherResponseDTO>> getById(UUID id) {
        VoucherResponseDTO voucherResponseDTO = voucherService.getById(id);
        return ResponseHandler.success(voucherResponseDTO);
    }

    @Override
    public ResponseEntity<ApiResponse<Void>> delete(UUID id) {
        voucherService.delete(id);
        return ResponseHandler.success(null);
    }

    @Override
    public ResponseEntity<ApiResponse<Page<VoucherResponseDTO>>> getAll(PagingAndSortingRequest request, Pageable pageable) {
        // gọi service để lấy danh sách user
        Page<VoucherResponseDTO> voucherResponseDtoPage = voucherService.getAll(request.toPageable());
        // trả về response thành công
        return ResponseHandler.success(voucherResponseDtoPage);
    }

}

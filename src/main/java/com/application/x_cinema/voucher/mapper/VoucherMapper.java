package com.application.x_cinema.voucher.mapper;

import com.application.x_cinema.common.mapper.BaseMapper;
import com.application.x_cinema.voucher.dto.request.CreateVoucherDTO;
import com.application.x_cinema.voucher.dto.request.UpdateVoucherDTO;
import com.application.x_cinema.voucher.dto.request.VoucherRequestDTO;
import com.application.x_cinema.voucher.dto.response.VoucherResponseDTO;
import com.application.x_cinema.voucher.entity.Voucher;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface VoucherMapper extends BaseMapper<VoucherRequestDTO, VoucherResponseDTO, Voucher> {
    // 1.ánh xạ request sang entity ()
    @Override
    @Mapping(target = "id", ignore = true)
    Voucher toEntity(VoucherRequestDTO requestDto);


    // 2.ánh xạ từ entity sang response (đọc dữ liệu với id)
    @Override
    @Mapping(source = "id", target = "id")
    VoucherResponseDTO toResponse(Voucher voucher);

    // 3.anh xa tu create sang request
    VoucherRequestDTO toRequest(CreateVoucherDTO dto);

    // 4.anh xa tu update sang request
    VoucherRequestDTO toRequest(UpdateVoucherDTO dto);

    // 5.update tu request sang entity (bo qua cac truong null)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDTO(VoucherRequestDTO requestDto, @MappingTarget Voucher voucher);
}

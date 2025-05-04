package com.application.x_cinema.seat.service;

import com.application.x_cinema.common.enums.ErrorCode;
import com.application.x_cinema.common.exception.AppException;
import com.application.x_cinema.seat.dto.request.SeatRequestDTO;
import com.application.x_cinema.seat.dto.respone.SeatResponseDTO;
import com.application.x_cinema.seat.entity.Seat;
import com.application.x_cinema.seat.mapper.SeatMapper;
import com.application.x_cinema.seat.repository.SeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SeatServiceImpl implements SeatService{

    // 1. Khai báo SeatRepository
    private final SeatRepository repository;
    // 2. Khai báo SeatMapper
    private final SeatMapper mapper;

    @Override
    public Page<SeatResponseDTO> getByRoomId(UUID roomId, Pageable pageable) {
        // 1. Truy vấn dữ liệu từ id và pageable truyền vào và trả về page
        Page<Seat> seatPage = repository.findByRoomId(roomId, pageable);
        // 2. Map từ Paege<Seat> sang Page<SeatResponseDTO>
        return seatPage.map(mapper::toResponse);
    }

    @Override
    @Transactional
    public SeatResponseDTO create(SeatRequestDTO dto) {
        // 1. Map từ SeatRequestDTO sang Seat
        Seat seat = mapper.toEntity(dto);
        // 2. Lưu vào database
        seat = repository.save(seat);
        // 3. Map từ Seat sang SeatResponseDTO
        return mapper.toResponse(seat);
    }

    @Override
    @Transactional
    public SeatResponseDTO update(UUID id, SeatRequestDTO dto) {
        // 1. Tìm kiếm Seat theo uuid
        Seat seat = repository.findById(id).orElseThrow(() -> new AppException(ErrorCode.SEAT_NOT_FOUND));
        // 2. Cập nhật dữ liệu từ SeatRequestDTO vào Seat dùng mapper
        mapper.updateEntityFromDTO(dto, seat);
        // 3. Lưu vào database
        Seat updatedSeat = repository.save(seat);
        // 4. Map từ Seat sang SeatResponseDTO
        return mapper.toResponse(updatedSeat);
    }

    @Override
    public SeatResponseDTO getById(UUID id) {
        // 1. Tìm kiếm Seat theo uuid
        Seat seat = repository.findById(id).orElseThrow(() -> new AppException(ErrorCode.SEAT_NOT_FOUND));
        // 2. Map từ Seat sang SeatResponseDTO
        return mapper.toResponse(seat);
    }

    @Override
    public Page<SeatResponseDTO> getAll(Pageable pageable) {
        // 1. Truy vấn dữ liệu từ pageable truyền vào và trả về page
        Page<Seat> seatPage = repository.findAll(pageable);
        // 2. Map từ Paege<Seat> sang Page<SeatResponseDTO>
        return seatPage.map(mapper::toResponse);
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        // 1. Tìm kiếm Seat theo uuid
        Seat seat = repository.findById(id).orElseThrow(() -> new AppException(ErrorCode.SEAT_NOT_FOUND));
        // 2. Xóa Seat
        repository.delete(seat);
    }
}
